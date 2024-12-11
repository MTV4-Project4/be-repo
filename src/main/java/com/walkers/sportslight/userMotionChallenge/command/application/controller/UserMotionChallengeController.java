package com.walkers.sportslight.userMotionChallenge.command.application.controller;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddResponseDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddServiceDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.service.UserMotionChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@Slf4j
@Tag(name = "크리에이터 챌린지 참가 api", description = "유사한 동작을 흉내내는 크리에이터 챌린지 참가 정보를 관리하는 API")
public class UserMotionChallengeController {

    private UserMotionChallengeService userMotionChallengeService;

    public UserMotionChallengeController(UserMotionChallengeService userMotionChallengeService) {
        this.userMotionChallengeService = userMotionChallengeService;
    }

    @Operation(summary = "크리에이터 챌린지 참가")
    @PostMapping("user/{userNo}/motion-challenge/{motionChallengeId}")
    @ResponseStatus(value = HttpStatus.CREATED)
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
