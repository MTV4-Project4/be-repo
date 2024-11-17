package com.walkers.sportslight.userInventory.command.domain.repository;

import com.walkers.sportslight.userInventory.command.domain.aggregate.InventoryItemType;
import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInventoryRepository extends JpaRepository<UserInventory, Long> {

    void deleteByItemId(long itemId);
    Optional<UserInventory> findByItemIdAndUserNo(long itemId, long userNo);
    Optional<UserInventory> findByIsEquippedAndItemTypeAndUserNo(String isEquipped, InventoryItemType itemType, Long userNo);

}
