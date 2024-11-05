package com.walkers.sportslight.userInventory.command.domain.repository;

import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInventoryRepository extends JpaRepository<UserInventory, Long> {

    void deleteByItemId(long itemId);
    Optional<UserInventory> findByItemId(long itemId);
}
