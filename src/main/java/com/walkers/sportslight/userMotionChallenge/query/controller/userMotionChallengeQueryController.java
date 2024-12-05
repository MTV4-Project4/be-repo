package com.walkers.sportslight.userMotionChallenge.query.controller;


import com.walkers.sportslight.userMotionChallenge.query.dto.UserMotionChallengeResult;
import com.walkers.sportslight.userMotionChallenge.query.service.UserMotionChallengeQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Tag(name = "크리에이터 챌린지 참가 정보 api", description = "크리에이터 챌린지 참가 내역을 조회하는 API")

public class userMotionChallengeQueryController {

    private UserMotionChallengeQueryService userMotionChallengeQueryService;

    public userMotionChallengeQueryController(UserMotionChallengeQueryService userMotionChallengeQueryService) {
        this.userMotionChallengeQueryService = userMotionChallengeQueryService;
    }


    @GetMapping("user-motion-challenge/{userMotionChallengeId}/summary")
    @ResponseStatus(value = HttpStatus.OK)
    public UserMotionChallengeResult getUserChallengeResultById (@PathVariable long userMotionChallengeId){
        return userMotionChallengeQueryService.findChallengeResultById(userMotionChallengeId);
    }

//
//    @GetMapping("user/{userNo}/motion-challenge/{motionChallengeId}")
//    public UserMotionChallengeResult getUserMotionChallengeResult (long userMotionChallengeId){
//
//    }

}

