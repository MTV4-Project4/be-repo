package com.walkers.sportslight.userInventory.query.dto;

import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvatarDTO {
    private String itemName;
    private ItemType itemType;
//    private String itemAvatarPath;
}
