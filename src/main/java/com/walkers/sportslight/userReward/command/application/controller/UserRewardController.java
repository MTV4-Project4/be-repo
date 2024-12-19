package com.walkers.sportslight.userReward.command.application.controller;

import com.walkers.sportslight.userReward.command.application.dto.UserRewardDTO;
import com.walkers.sportslight.userReward.command.application.service.UserRewardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRewardController {

    private UserRewardService userRewardService;

    @ResponseStatus(HttpStatus.CREATED)
    public void addUserRewardInfo(@RequestBody UserRewardDTO userRewardInfo) {


    }
}
