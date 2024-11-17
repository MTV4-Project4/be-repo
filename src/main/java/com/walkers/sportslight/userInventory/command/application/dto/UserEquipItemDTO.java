package com.walkers.sportslight.userInventory.command.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class UserEquipItemDTO {
    private List<Long> equipItems;
}
