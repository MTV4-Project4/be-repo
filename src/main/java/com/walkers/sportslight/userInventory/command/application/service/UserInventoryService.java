package com.walkers.sportslight.userInventory.command.application.service;

import com.walkers.sportslight.item.command.application.service.ItemService;
import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.userInventory.command.application.dto.UserInventoryMapper;
import com.walkers.sportslight.userInventory.command.application.dto.UserItemAddServiceDTO;
import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import com.walkers.sportslight.userInventory.command.domain.repository.UserInventoryRepository;
import com.walkers.sportslight.userInventory.command.domain.service.ItemInfoFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInventoryService {

    private final UserInventoryRepository userInventoryRepository;
    private final UserInventoryMapper userInventoryMapper;
    private final ItemInfoFindService itemInfoFindService;

    public UserInventory findByItemIdAndUserNo(long itemId, long userNo) {
        return  userInventoryRepository.findByItemIdAndUserNo(itemId, userNo)
                .orElseThrow(()-> new NoSuchElementException("해당 아이템을 갖고 있지 않습니다."));
    }

    public Optional<UserInventory> findUserEquipItemByType(InventoryItemType itemType, long userNo){
        return userInventoryRepository.findByIsEquippedAndItemTypeAndUserNo(
                "Y", itemType, userNo
        );
    }

    @Transactional
    public void addUserInventory(UserItemAddServiceDTO addInfo) {
        addInfo.setItemType(
                itemInfoFindService.getItemTypeByItemId(addInfo.getItemId())
        );
        UserInventory userInventory = userInventoryMapper.toUserInventory(addInfo);
        userInventoryRepository.save(userInventory);
    }

    @Transactional
    public void equipItem(long itemId, long userNo) {
        UserInventory toEquip = findByItemIdAndUserNo(itemId, userNo);
        Optional<UserInventory> equippedSameTypeItem = findUserEquipItemByType(
                toEquip.getItemType(), userNo
        );

        equippedSameTypeItem.ifPresent(userInventory -> userInventory.setIsEquipped("N"));
        toEquip.setIsEquipped("Y");
    }

    @Transactional
    public void unEquipItem(long itemId, long userNo){
        UserInventory toUnEquip = findByItemIdAndUserNo(itemId, userNo);
        toUnEquip.setIsEquipped("N");
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
