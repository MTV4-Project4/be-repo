package com.walkers.sportslight.userInventory.command.domain.service;

import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;

public interface ItemInfoFindService{
    InventoryItemType getItemTypeByItemId(long itemId);

}
