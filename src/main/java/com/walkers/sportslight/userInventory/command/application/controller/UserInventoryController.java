package com.walkers.sportslight.userInventory.command.application.controller;


import com.walkers.sportslight.userInventory.command.application.dto.UserEquipItemDTO;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
public class UserInventoryController {

    private UserInventoryService userInventoryService;

    public UserInventoryController(UserInventoryService userInventoryService) {
        this.userInventoryService = userInventoryService;
    }

    @PutMapping("user/{userNo}/equip")
    public void setEquipItems(@PathVariable long userNo, @RequestBody UserEquipItemDTO userEquipItemIfo){
        log.debug("to equip user:{}, to equip item:{}", userNo, userEquipItemIfo);

        userInventoryService.equipMultipleItem(
                userEquipItemIfo.getEquipItems(), userNo);
    }
}
