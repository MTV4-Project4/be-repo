package com.walkers.sportslight.userMotionChallenge.query.controller;


import com.walkers.sportslight.userMotionChallenge.query.dto.UserMotionChallengeResult;
import com.walkers.sportslight.userMotionChallenge.query.service.UserMotionChallengeQueryService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
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

