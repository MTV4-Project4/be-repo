package com.walkers.sportslight.challengeFavorites.command.application.controller;

import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteRegistDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.response.MotionChallengeLikeResponseDTO;
import com.walkers.sportslight.challengeFavorites.command.application.service.MotionChallengeLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
@Tag(name = "나만의 챌린지 피드 좋아요")
public class MotionChallengeLikeController {

    private MotionChallengeLikeService motionChallengeLikeService;

    public MotionChallengeLikeController(MotionChallengeLikeService motionChallengeLikeService) {
        this.motionChallengeLikeService = motionChallengeLikeService;
    }

    @Operation(summary = "챌린지 피드 좋아요 추가")
    @PostMapping("user/{userNo}/motion-challenge/{motionChallengeId}/like")
    @ResponseStatus(HttpStatus.CREATED)
    public MotionChallengeLikeResponseDTO addMotionLike(@PathVariable long userNo,
                                                        @PathVariable long motionChallengeId){

        ChallengeFavoriteAddServiceDTO challengeFavoriteAddInfo =
                new ChallengeFavoriteAddServiceDTO(
                        userNo, motionChallengeId,
                        LocalDateTime.now()
                );

        return new MotionChallengeLikeResponseDTO(
                motionChallengeLikeService.addLike(challengeFavoriteAddInfo)
        );
    }

    @Operation(summary = "챌린지 피드 좋아요 취소")
    @DeleteMapping("user/{userNo}/motion-challenge/{motionChallengeId}")
    public void cancelMotionLike(@PathVariable long userNo, @PathVariable long motionChallengeId){
        motionChallengeLikeService.deleteByUserNoAndChallengeId(userNo, motionChallengeId);
    }


}
