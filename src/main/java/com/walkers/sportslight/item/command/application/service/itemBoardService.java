package com.walkers.sportslight.item.command.application.service;

import com.walkers.sportslight.item.command.application.dto.ItemMapper;
import com.walkers.sportslight.item.command.domain.aggregate.Item;
import com.walkers.sportslight.item.command.domain.repository.ItemRepository;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class itemBoardService {

    private final ItemRepository itemRepository;
    private final UserInventoryService userInventoryService;


    public Item findItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("해당하는 아이템은 존재하지 않습니다.")
        );
    }

    @Transactional
    public long addItemInfo(Item item, String imageUrl){
        item.setItemImageUrl(imageUrl);
        return itemRepository.save(item).getItemId();
    }

    @Transactional
    public String deleteItemInfo(long itemId) {
        Item item = findItemById(itemId);
        String oldFileUrl = item.getItemImageUrl();
        itemRepository.deleteById(itemId);
        userInventoryService.deleteByItemId(itemId);

        return oldFileUrl;
    }
}
