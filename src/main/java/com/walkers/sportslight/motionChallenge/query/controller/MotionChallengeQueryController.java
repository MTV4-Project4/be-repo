package com.walkers.sportslight.motionChallenge.query.controller;

import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeContentResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeImageResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeResponseDTO;
import com.walkers.sportslight.motionChallenge.query.service.MotionChallengeQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "유저 챌린지 조회 API")
@RestController
@RequestMapping("api")
public class MotionChallengeQueryController {

    private MotionChallengeQueryService motionChallengeQueryService;

    public MotionChallengeQueryController(MotionChallengeQueryService motionChallengeQueryService) {
        this.motionChallengeQueryService = motionChallengeQueryService;
    }

    @Operation(summary = "모션 챌린지 목록")
    @GetMapping("/motion-challenge")
    public List<MotionChallengeResponseDTO> findMotionChallengeList(){
        return motionChallengeQueryService.findMotionChallenges();
    }

    @Operation(summary = "모셜 챌린지 조회")
    @GetMapping("/motion-challenge/{challengeId}")
    public MotionChallengeResponseDTO findMotionChallengeList(@PathVariable long challengeId){
        return motionChallengeQueryService.findMotionChallengeById(challengeId);
    }

    @Operation(summary = "모션 챌린지 텍스트 내용 보기")
    @GetMapping("/motion-challenge/{motionChallengeId}/content")
    public MotionChallengeContentResponseDTO findMotionChallengeContent(
            @PathVariable long motionChallengeId
    ) {
        return motionChallengeQueryService.findMotionChallengeContentById(motionChallengeId);
    }

    @Operation(summary = "모션 챌린지 이미지 보기")
    @GetMapping("/motion-challenge/{motionChallengeId}/image")
    public MotionChallengeImageResponseDTO findMotionChallengeImage(
            @PathVariable long motionChallengeId
    ) {
        return motionChallengeQueryService.findMotionChallengeImageById(motionChallengeId);
    }
}
