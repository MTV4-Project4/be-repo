package com.walkers.sportslight.userMatch.command.application.controller;

import com.walkers.sportslight.userMatch.command.application.dto.UserMatchRequest;
import com.walkers.sportslight.userMatch.command.application.dto.UserMatchServiceRequest;
import com.walkers.sportslight.userMatch.command.application.service.UserMatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
@Tag(name = "유저 대전 API", description = "유저들기리 하는 챌린지 대전 정보를 관리하는 API")
public class UserMatchController {

    private UserMatchService userMatchService;

    public UserMatchController(UserMatchService userMatchService) {
        this.userMatchService = userMatchService;
    }

    @Operation(summary = "대전 정보 등록", description = "챌린지 대전 결과 정보를 등록")
    @PostMapping("match/challenge/{challengeId}")
    private long addUserMatch(@PathVariable long challengeId,  @RequestBody UserMatchRequest userMatchRequest) {
        return userMatchService.addUserMatch(
                new UserMatchServiceRequest(userMatchRequest, challengeId, LocalDateTime.now())
        );
    }

    @Operation(summary = "대전 정보 삭제", description = "유저 챌린지 대전 결과 정보를 삭제")
    @DeleteMapping("match/{matchId}")
    private void removeUserMatch(@PathVariable long matchId) {
        userMatchService.deleteUserMatchById(matchId);
    }
}
