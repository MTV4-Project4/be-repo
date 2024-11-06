package com.walkers.sportslight.item.command.domain.aggregate;

import com.walkers.sportslight.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private int itemPrice;
    private String itemImageUrl;
    private String itemAvatarPath;

    @Builder
    public Item(String itemName, ItemType itemType, int itemPrice, String itemAvatarPath) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemAvatarPath = itemAvatarPath;
    }



    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }
}
