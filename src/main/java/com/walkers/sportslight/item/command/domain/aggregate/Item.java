package com.walkers.sportslight.item.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    private String itemName;
    private String itemDescription;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    private int itemPrice;
    private String itemImageUrl;


    @Builder
    public Item(String itemName, String itemDescription, ItemType itemType, int itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
    }

    public void setItemImageUrl(String itemImageUrl) {
        this.itemImageUrl = itemImageUrl;
    }
}
