package com.walkers.sportslight.userInventory.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInventoryResponseDTO {
    private long userNo;
    private List<UserInventoryListDTO> itemList;
}
