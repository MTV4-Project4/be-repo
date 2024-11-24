package com.walkers.sportslight.userInventory.command.infrastructure.service;

import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.command.domain.repository.ItemRepository;
import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import com.walkers.sportslight.userInventory.command.domain.service.ItemInfoFindService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ItemInfoFindServiceImpl implements ItemInfoFindService {

    private final ItemRepository itemRepository;

    public ItemInfoFindServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public static InventoryItemType mapToInventoryType(ItemType itemType) {
        return InventoryItemType.valueOf(itemType.name());
    }


    @Override
    public InventoryItemType getItemTypeByItemId(long itemId) {
        ItemType itemtype = itemRepository.findById(itemId)
                .orElseThrow(() -> new NoSuchElementException("아이템을 찾을 수 없습니다."))
                .getItemType();

        return mapToInventoryType(itemtype);
    }
}