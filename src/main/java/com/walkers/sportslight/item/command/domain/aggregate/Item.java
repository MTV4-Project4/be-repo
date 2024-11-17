package com.walkers.sportslight.item.command.domain.aggregate;

import com.walkers.sportslight.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Item extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private int itemPrice;
    private String itemImageUrl;


    @Builder
    public Item(String itemName, ItemType itemType, int itemPrice, String itemImageUrl) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
        this.itemImageUrl = itemImageUrl;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }
}
