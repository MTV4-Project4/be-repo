package com.walkers.sportslight.userChallenge.command.application.controller;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeDeleteDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeRegistDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeRegistServiceDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeUpdateDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.response.UserChallengeAddResponseDTO;
import com.walkers.sportslight.userChallenge.command.application.service.UserChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("api")
@Tag(name = "유저 챌린지 참가 API", description = "유저의 챌린지 참가 정보를 기록하는 API")
public class UserChallengeController {

    private UserChallengeService userChallengeService;

    public UserChallengeController(UserChallengeService userChallengeService) {
        this.userChallengeService = userChallengeService;
    }

//    @GetMapping("userChallenge/try")
//    public String registChallengeTry(@ModelAttribute long userId, @ModelAttribute long challengeId){
//         log.info("try to regist challenge. userId:{}, challengeId:{}, time:{}",
//                 userId, challengeId, LocalDateTime.now());
//
//         return "None";
//    }


//    @Operation(summary = "참가 정보 등록")
//    @PostMapping("userChallenge/{id}")
//    public ApiResponse<?> addUserChallenge(@PathVariable("id") long id, @RequestBody UserChallengeUpdateDTO updateInfo) {
//
//        return userChallengeService.registUserChallenge(updateInfo);
//    }

    @Operation(summary = "참가 정보 등록")
    @PostMapping("user/{userNo}/challenge/{challengeId}")
    public UserChallengeAddResponseDTO addUserChallenge(@PathVariable long userNo, @PathVariable long challengeId
                                 ,@RequestBody UserChallengeRegistDTO registerInfo) {

        UserChallengeRegistServiceDTO userChallengeInfo =
                new UserChallengeRegistServiceDTO(userNo,
                        challengeId, registerInfo.getRecord(),
                        LocalDateTime.now());
        return new UserChallengeAddResponseDTO(
                userChallengeService.registUserChallenge(userChallengeInfo)
        );
    }

    @Operation(summary = "참가 정보 삭제")
    @DeleteMapping("userChallenge/{id}")
    public void deleteUserChallenge(@PathVariable("id") long userChallengeId){
        userChallengeService.deleteUserChallenge(
                new UserChallengeDeleteDTO(0, userChallengeId)
        );
    }
}
