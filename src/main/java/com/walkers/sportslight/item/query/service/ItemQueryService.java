package com.walkers.sportslight.item.query.service;

import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.query.dto.ItemResponseDTO;
import com.walkers.sportslight.item.query.repository.ItemQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemQueryService {

    private ItemQueryRepository itemQueryRepository;

    public ItemQueryService(ItemQueryRepository itemQueryRepository) {
        this.itemQueryRepository = itemQueryRepository;
    }

    public List<ItemResponseDTO> findByItemType(ItemType itemType){
        return itemQueryRepository.findByItemType(itemType);
    }

    public List<ItemResponseDTO> findItems() {
        return itemQueryRepository.findItems();
    }

    public ItemResponseDTO findById(long itemId) {
        return itemQueryRepository.findById(itemId);
    }
}
