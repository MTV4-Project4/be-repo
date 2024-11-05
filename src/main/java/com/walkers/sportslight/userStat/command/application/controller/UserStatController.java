package com.walkers.sportslight.userStat.command.application.controller;

import com.walkers.sportslight.userStat.command.application.dto.UserStatRequestDTO;
import com.walkers.sportslight.userStat.command.application.service.UserStatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserStatController {

    private UserStatService userStatService;

    public UserStatController(UserStatService userStatService) {
        this.userStatService = userStatService;
    }

    @PutMapping("userStat/{statId}")
    public void updateUserStat(@PathVariable long statId,
                               @RequestBody UserStatRequestDTO userStat){

    }
}
