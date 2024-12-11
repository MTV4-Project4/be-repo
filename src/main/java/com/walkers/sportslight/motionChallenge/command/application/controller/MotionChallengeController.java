package com.walkers.sportslight.motionChallenge.command.application.controller;

import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeAddRequest;
import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeAddResponseDTO;
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
@Tag(name = "모션 챌린지 관리 API", description = "유저 크리에이터 챌린지를 등록하거나, 삭제하는 기능을 제공하는 API")
public class MotionChallengeController {

    private MotionChallengeService motionChallengeService;

    public MotionChallengeController(MotionChallengeService motionChallengeService) {
        this.motionChallengeService = motionChallengeService;
    }


    @Operation(summary = "모션 챌린지 내용 생성", description = "크리에이터 모션 챌린지의 텍스트 내용을 새로 생성합니다.")
    @PostMapping("motion-challenge/content")
    public MotionChallengeAddResponseDTO motionChallengeAdd(@RequestBody @Valid MotionChallengeAddRequest addRequest){
        log.info("try to make motion challenge content, challengeInfo:{}", addRequest);

        long addId = motionChallengeService.addMotionChallenge(addRequest);
        return new MotionChallengeAddResponseDTO(addId);
    }

    @Operation(summary = "모션 챌린지 이미지 설정", description = "지정한 모션 챌린지의 이미지를 설정합니다.")
    @PostMapping("motion-challenge/{motionChallengeId}/image")
    public void motionChallengeImageUpdate(@PathVariable long motionChallengeId,
                                           @RequestParam("file") MultipartFile file){

        log.info("try to set motion challenge image, challengeId:{}",motionChallengeId);

        motionChallengeService.updateMotionChallengeImage(
               motionChallengeId, file
        );
    }


    @Operation(summary = "모션 챌린지 신규 생성", description = "모션 챌린지를 내용과 이미지를 가지고 새로 생성합니다.")
    @PostMapping("motion-challenge")
    public MotionChallengeAddResponseDTO addMotionChallenge(@ModelAttribute @Valid MotionChallengeAddRequest addRequest) {

        long addId = motionChallengeService.addMotionChallenge(addRequest);
        log.info("make motion challenge success, motionChallengeId:{}", addId);
        return new MotionChallengeAddResponseDTO(addId);
        //return motionChallengeService.addMotionChallenge();
    }


    @Operation(summary = "모션 챌린지 삭제", description = "지정한 모션 챌린지를 삭제합니다.")
    @DeleteMapping("motion-challenge/{motionChallengeId}")
    public void deleteMotionChallenge(@PathVariable long motionChallengeId){

        motionChallengeService.deleteMotionChallenge(motionChallengeId);

    }

}
