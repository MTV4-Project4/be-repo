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
    private LocalDateTime acquireAt;

    public UserInventory(long userId, long itemId, LocalDateTime acquireAt) {
        this.userId = userId;
        this.itemId = itemId;
        this.acquireAt = acquireAt;
    }
}
