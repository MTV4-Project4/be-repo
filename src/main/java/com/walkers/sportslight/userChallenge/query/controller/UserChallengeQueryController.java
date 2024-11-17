package com.walkers.sportslight.userChallenge.query.controller;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeListDTO;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeResponseArrayDTO;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeResponseDTO;
import com.walkers.sportslight.userChallenge.query.service.UserChallengeQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api")
@Tag(name = "유저 참여 챌린지 조회 api", description = "유저가 참여한 챌린지에 대한 기록을 조회")
public class UserChallengeQueryController {

    private UserChallengeQueryService userChallengeQueryService;

    public UserChallengeQueryController(UserChallengeQueryService userChallengeQueryService) {
        this.userChallengeQueryService = userChallengeQueryService;
    }

    @Operation(summary = "유저 참여 챌린지 조회",description = "지정한 유저가 참여한 챌린지 기록을 조회")
    @GetMapping("user/{userNo}/challenge")
    public List<UserChallengeResponseDTO> getUserChallengeList(@PathVariable long userNo) {
        return userChallengeQueryService.findByUserNo(userNo);
    }

    @Operation(summary = "유저 참여 챌린지 순위 조회", description = "유저가 참여한 특정 챌린지에 대한 기록을 조회")
    public UserChallengeResponseDTO getUserChallengeRecord(@PathVariable long userNo, @PathVariable long challengeId){
        return userChallengeQueryService.findUserChallengeRecord(userNo, challengeId);

    }

    @GetMapping("/test")
    public UserChallengeResponseArrayDTO testUserChallengeList() {
        return new UserChallengeResponseArrayDTO(
                List.of(
                        new UserChallengeListDTO(1, 1, "제자리 뛰기 챌린지", 61, 2, LocalDateTime.of(2024, 11, 7, 13, 20))
                        , new UserChallengeListDTO(2, 2, "스쿼트 챌린지", 23, 1, LocalDateTime.of(2024, 11, 6, 17, 0))
                        , new UserChallengeListDTO(3, 1, "1분 축구공 리프팅 챌린지", 15, 4, LocalDateTime.of(2024, 11, 6, 17, 30))
                )
        );
    }

}
