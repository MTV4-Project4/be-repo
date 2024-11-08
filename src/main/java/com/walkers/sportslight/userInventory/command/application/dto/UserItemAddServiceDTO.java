package com.walkers.sportslight.userInventory.command.application.dto;

import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserItemAddServiceDTO {
    private final long userNo;
    private final long itemId;
    private final LocalDateTime acquireAt;
    private InventoryItemType itemType;
    private String isEquipped="N";

    public void setItemType(InventoryItemType itemType) {
        this.itemType = itemType;
    }

    public void setIsEquipped(String isEquipped) {
        this.isEquipped = isEquipped;
    }
}
