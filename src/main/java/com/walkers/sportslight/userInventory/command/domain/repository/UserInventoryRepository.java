package com.walkers.sportslight.userInventory.command.domain.repository;

import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInventoryRepository extends JpaRepository<UserInventory, Long> {
}
