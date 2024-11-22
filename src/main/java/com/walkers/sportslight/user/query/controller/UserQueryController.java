package com.walkers.sportslight.user.query.controller;

import com.walkers.sportslight.user.query.dto.AccountInfoResponseDTO;
import com.walkers.sportslight.user.query.dto.UserProfileDTO;
import com.walkers.sportslight.user.query.service.UserQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@Slf4j
public class UserQueryController {

    private UserQueryService userQueryService;

    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Operation(summary = "유저 프로필 조회", 
        description = "지정한 유저의 계정 정보를 조회합니다.")
    @GetMapping("{userNo}")
    public AccountInfoResponseDTO getUserProfile(@PathVariable long userNo){
        log.debug("try to accountInfo, userNo:{}", userNo);
        return userQueryService.findAccountByUserNo(userNo);
    }

//    @GetMapping("{userNo}")
//    public UserProfileDTO getUserProfile(@PathVariable long userNo){
//
//
//
//    }
}
