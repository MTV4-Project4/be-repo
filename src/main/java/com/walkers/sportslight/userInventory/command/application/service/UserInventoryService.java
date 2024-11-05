package com.walkers.sportslight.userInventory.command.application.service;

import com.walkers.sportslight.item.command.application.service.ItemService;
import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.userInventory.command.application.dto.UserInventoryMapper;
import com.walkers.sportslight.userInventory.command.application.dto.UserItemAddServiceDTO;
import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import com.walkers.sportslight.userInventory.command.domain.repository.UserInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserInventoryService {

    public static InventoryItemType mapToInventoryType(ItemType itemType) {
        return InventoryItemType.valueOf(itemType.name());
    }

    private final UserInventoryRepository userInventoryRepository;
    private final UserInventoryMapper userInventoryMapper;
    private final ItemService itemService;

    public UserInventory findByItemId(Long itemId) {
        return  userInventoryRepository.findByItemId(itemId)
                .orElseThrow(()-> new NoSuchElementException("해당 아이템을 갖고 있지 않습니다."));
    }

    @Transactional
    public void addUserInventory(UserItemAddServiceDTO addInfo) {
        addInfo.setItemType(
                mapToInventoryType(
                itemService.getItemTypeByItemId(addInfo.getItemId()))
        );
        UserInventory userInventory = userInventoryMapper.toUserInventory(addInfo);
        userInventoryRepository.save(userInventory);
    }

    @Transactional
    public void deleteUserInventory(long userInventoryId){
        userInventoryRepository.deleteById(userInventoryId);
    }

    @Transactional
    public void deleteByItemId(long itemId) {
        userInventoryRepository.deleteByItemId(itemId);
    }

}
