package com.walkers.sportslight.userStat.command.application.controller;

import com.walkers.sportslight.userStat.command.application.dto.UserStatRequestDTO;
import com.walkers.sportslight.userStat.command.application.dto.UserStatUpdateDTO;
import com.walkers.sportslight.userStat.command.application.service.UserStatService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@Tag(name = "유저 스탯 API", description = "유저 경험치와 스탯을 관리하는 API")
@Slf4j
public class UserStatController {

    private UserStatService userStatService;

    public UserStatController(UserStatService userStatService) {
        this.userStatService = userStatService;
    }

    @Hidden
    @PutMapping("userStat/{statId}")
    public void updateUserStat(@PathVariable long statId,
                               @RequestBody UserStatRequestDTO userStat){

    }
//
//    @PutMapping("{userNo}/stats")
//    public ResponseEntity<Void> updateSingleStat(@RequestBody UserStatUpdateRequest request) {
//        //userStatService.updateUserStat(request);
//        userStatService.updateStatExperience(request);
//        return ResponseEntity.ok().build();
//    }

    @Operation(summary = "스탯 업데이트", description = "유저 스탯을 업데이트 합니다.")
    @PutMapping("{userNo}/stats")
    public ResponseEntity<Void> updateMultipleStats(@PathVariable long userNo, @RequestBody UserStatUpdateDTO requests) {
        log.debug("req: {}", requests);
        userStatService.updateMultipleStats(userNo, requests.getUpgrades());
        return ResponseEntity.ok().build();
    }
}
