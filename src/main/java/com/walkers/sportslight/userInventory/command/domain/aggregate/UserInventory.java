package com.walkers.sportslight.userInventory.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class UserInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInventoryId;

    private long userId;
    private long itemId;

    @Enumerated(EnumType.STRING)
    private InventoryItemType itemType;
    private LocalDateTime acquireAt;

    private String isEquipped;

    public UserInventory(long userId, long itemId, InventoryItemType itemType, LocalDateTime acquireAt, String isEquipped) {
        this.userId = userId;
        this.itemId = itemId;
        this.itemType = itemType;
        this.acquireAt = acquireAt;
        this.isEquipped = isEquipped;
    }
}
