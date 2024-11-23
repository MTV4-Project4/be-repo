package com.walkers.sportslight.motionChallenge.command.application.controller;

import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeAddRequest;
import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeAddResponseDTO;
import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeImageSetDTO;
import com.walkers.sportslight.motionChallenge.command.application.service.MotionChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api")
@Slf4j
@Tag(name = "모션 챌린지 관리 API", description = "모션 챌린지를 관리하는 API")
public class MotionChallengeController {

    private MotionChallengeService motionChallengeService;

    public MotionChallengeController(MotionChallengeService motionChallengeService) {
        this.motionChallengeService = motionChallengeService;
    }


    @Operation(summary = "모션 챌린지 내용 생성")
    @PostMapping("motion-challenge/content")
    public MotionChallengeAddResponseDTO motionChallengeAdd(@RequestBody @Valid MotionChallengeAddRequest addRequest){
        log.info("try to make motion challenge content, challengeInfo:{}", addRequest);

        long addId = motionChallengeService.addMotionChallenge(addRequest);
        return new MotionChallengeAddResponseDTO(addId);
    }

    @Operation(summary = "모션 챌린지 이미지 설정")
    @PostMapping("motion-challenge/{motionChallengeId}/image")
    public void motionChallengeImageUpdate(@PathVariable long motionChallengeId,
                                           @RequestParam("file") MultipartFile file){

        log.info("try to set motion challenge image, challengeId:{}",motionChallengeId);

        motionChallengeService.updateMotionChallengeImage(
               motionChallengeId, file
        );
    }



    //누가 보류한대서 주석해둠
//    @Operation(summary = "모션 챌린지 생성")
//    @PostMapping("challenge/motion")
//    public MotionChallengeAddResponseDTO motionChallengeAdd(@ModelAttribute @Valid MotionChallengeAddRequest addRequest) {
//        log.info("try to make motion challenge, challengeInfo:{}", addRequest);
//
//        long addId = motionChallengeService.addMotionChallenge(addRequest);
//        log.info("make motion challenge success, motionChallengeId:{}", addId);
//        return new MotionChallengeAddResponseDTO(addId);
//        //return motionChallengeService.addMotionChallenge();
//    }


    @Operation(summary = "모션 챌린지 삭제")
    @DeleteMapping("challenge/motion/{motionChallengeId}")
    public void deleteMotionChallenge(@PathVariable long motionChallengeId){

        motionChallengeService.deleteMotionChallenge(motionChallengeId);

    }

}
