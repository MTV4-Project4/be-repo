package com.walkers.sportslight.item.query.dto;

import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemResponseDTO {
    private long itemId;
    private String itemName;
    private String itemImageUrl;
    private ItemType itemType;
}
