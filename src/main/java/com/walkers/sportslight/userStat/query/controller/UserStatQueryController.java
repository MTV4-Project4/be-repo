package com.walkers.sportslight.userStat.query.controller;

import com.walkers.sportslight.userStat.query.dto.UserStatsResponse;
import com.walkers.sportslight.userStat.query.service.UserStatQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "스탯 조회 API", description = "유저 경험치와 스탯을 조회하는 API")
@RequestMapping("api")
@RestController
@Slf4j
public class UserStatQueryController {

    private UserStatQueryService userStatQueryService;

    public UserStatQueryController(UserStatQueryService userStatQueryService) {
        this.userStatQueryService = userStatQueryService;
    }

//    @GetMapping("/userStat/testOne")
//    public UserStatJsonResponseDTO test(){
//        return userStatQueryService.findJsonByUserNo(1);
//    }

    @Operation(summary = "유저 스탯 조회", description = "지정한 유저의 스탯 정보를 조회합니다.")
    @GetMapping("user/{userNo}/stats")
    public ResponseEntity<UserStatsResponse> getUserStat(@PathVariable long userNo){
        log.debug("조회할 유저 번호 : {}", userNo);
        UserStatsResponse response = userStatQueryService.getUserStats(userNo);
        return ResponseEntity.ok(response);
    }
}
