package com.walkers.sportslight.userInventory.command.application.controller;


import com.walkers.sportslight.userInventory.command.application.dto.UserEquipItemDTO;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserInventoryController {

    private UserInventoryService userInventoryService;

    public UserInventoryController(UserInventoryService userInventoryService) {
        this.userInventoryService = userInventoryService;
    }

    @PostMapping("user/{userNo}/equip")
    public void setEquipItems(@PathVariable long userNo, @RequestBody UserEquipItemDTO userEquipItemIfo){
        System.out.println(userEquipItemIfo.getEquipItems());
        userInventoryService.equipMultipleItem(
                userEquipItemIfo.getEquipItems(), userNo);
    }
}
