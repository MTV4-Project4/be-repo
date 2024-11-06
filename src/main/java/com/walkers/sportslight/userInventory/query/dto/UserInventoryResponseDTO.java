package com.walkers.sportslight.userInventory.query.dto;

import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInventoryResponseDTO {
    private long userInventoryId;
    private long itemId;
    private String itemName;
    private String itemImageUrl;
    private InventoryItemType itemType;
    private String isEquipped;
}
