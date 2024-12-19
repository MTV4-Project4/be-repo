package com.walkers.sportslight.userChallenge.query.controller;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.userChallenge.query.dto.*;
import com.walkers.sportslight.userChallenge.query.service.UserChallengeQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@Tag(name = "유저 참여 챌린지 조회 api", description = "유저가 참여한 챌린지에 대한 기록을 조회")
public class UserChallengeQueryController {

    private UserChallengeQueryService userChallengeQueryService;

    public UserChallengeQueryController(UserChallengeQueryService userChallengeQueryService) {
        this.userChallengeQueryService = userChallengeQueryService;
    }

    @Operation(summary = "유저 참여 챌린지 목록 조회",description = "지정한 유저가 참여한 챌린지 목록을 조회")
    @GetMapping("user/{userNo}/challenge")
    public List<UserChallengeResponseDTO> getUserChallengeList(@PathVariable long userNo) {
        return userChallengeQueryService.findByUserNo(userNo);
    }

    @Operation(summary = "유저 참여 챌린지 기록 조회", description = "유저가 참여한 특정 챌린지에 대한 기록을 조회")
    @GetMapping("user/{userNo}/challenge/{challengeId}")
    @ResponseStatus(HttpStatus.OK)
    public UserChallengeResponseDTO getUserChallengeRecord(@PathVariable long userNo, @PathVariable long challengeId){
        return userChallengeQueryService.findUserChallengeRecord(userNo, challengeId);

    }

    @Operation(summary = "유저 참여 챌린지 순위 조회", description = "유저가 참여한 특정 챌린지에 대한 순위정보만 조회")
    @GetMapping("user/{userNo}/challenge/{challengeId}/rank")
    @ResponseStatus(HttpStatus.OK)
    public UserChallengeRecordDTO getUserChallengeRank(@PathVariable long userNo, @PathVariable long challengeId){
        return userChallengeQueryService.findUserChallengeRank(userNo, challengeId);
    }

    @Operation(summary = "플레이 결과 화면 조회", description = "챌린지 플레이 후 순위, 기록과 같은 결과를 조회")
    @GetMapping("user-challenge/{userChallengeId}")
    @ResponseStatus(HttpStatus.OK)
    public UserChallengeResultDTO getUserChallengeResult(@PathVariable long userChallengeId){
        return userChallengeQueryService.findUserChallengeResult(userChallengeId);
    }


}
