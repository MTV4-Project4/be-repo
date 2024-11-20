package com.walkers.sportslight.userMotionChallenge.command.application.controller;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.MotionChallengeRequestDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddResponseDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddServiceDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.service.UserMotionChallengeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@Slf4j
public class UserMotionChallengeController {

    private UserMotionChallengeService userMotionChallengeService;

    public UserMotionChallengeController(UserMotionChallengeService userMotionChallengeService) {
        this.userMotionChallengeService = userMotionChallengeService;
    }

    @PostMapping("user/{userNo}/motion-challenge/{motionChallengeId}")
    public UserChallengeAddResponseDTO addUserMotionChallenge(@PathVariable long userNo,
                                                              @PathVariable long motionChallengeId,
                                                              @RequestParam("file") MultipartFile file) {

        log.info("try to participate motion-challenge userNo:{}, motionChallengeId:{}", userNo, motionChallengeId);
        return userMotionChallengeService.addUserMotionChallenge(
                new UserChallengeAddServiceDTO(
                        userNo, motionChallengeId, file
                )
            );

    }

}
