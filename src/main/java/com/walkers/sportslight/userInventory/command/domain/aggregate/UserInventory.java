package com.walkers.sportslight.userInventory.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class UserInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userInventoryId;

    private long userNo;
    private long itemId;

    @Enumerated(EnumType.STRING)
    private InventoryItemType itemType;
    private LocalDateTime acquireAt;

    @ColumnDefault("'Y'")
    private String isEquipped;

    @Builder
    public UserInventory(long userNo, long itemId, InventoryItemType itemType, LocalDateTime acquireAt, String isEquipped) {
        this.userNo = userNo;
        this.itemId = itemId;
        this.itemType = itemType;
        this.acquireAt = acquireAt;
        this.isEquipped = isEquipped;
    }

    public void setIsEquipped(String isEquipped) {
        this.isEquipped = isEquipped;
    }
}
