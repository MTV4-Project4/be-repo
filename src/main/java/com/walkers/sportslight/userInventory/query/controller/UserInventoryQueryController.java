package com.walkers.sportslight.userInventory.query.controller;

import com.walkers.sportslight.userInventory.query.dto.UserInventoryListDTO;
import com.walkers.sportslight.userInventory.query.dto.UserInventoryResponseDTO;
import com.walkers.sportslight.userInventory.query.service.UserInventoryQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserInventoryQueryController {

    private UserInventoryQueryService userInventoryQueryService;

    public UserInventoryQueryController(UserInventoryQueryService userInventoryQueryService) {
        this.userInventoryQueryService = userInventoryQueryService;
    }

    @GetMapping("user/{userNo}/inventory")
    public UserInventoryResponseDTO getUserInventory(@PathVariable long userNo){
        return userInventoryQueryService.findInventoryByUserNo(userNo);
    }
}
