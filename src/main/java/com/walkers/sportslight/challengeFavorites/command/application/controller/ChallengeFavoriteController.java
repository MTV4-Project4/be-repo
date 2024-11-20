package com.walkers.sportslight.challengeFavorites.command.application.controller;

import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteDeleteDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteRegistDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.response.ChallengeFavoriteAddResponseDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.response.MotionChallengeLikeResponseDTO;
import com.walkers.sportslight.challengeFavorites.command.application.service.ChallengeFavoriteService;
import com.walkers.sportslight.challengeFavorites.command.application.service.MotionChallengeLikeService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@Hidden
@Tag(name= "챌린지 즐겨찾기 api", description = "관심있는 챌린지를 즐겨찾기 하기 위한 API")
@Slf4j
public class ChallengeFavoriteController {

    private ChallengeFavoriteService challengeFavoriteService;
    private MotionChallengeLikeService motionChallengeLikeService;

    public ChallengeFavoriteController(ChallengeFavoriteService challengeFavoriteService, MotionChallengeLikeService motionChallengeLikeService) {
        this.challengeFavoriteService = challengeFavoriteService;
        this.motionChallengeLikeService = motionChallengeLikeService;
    }

    @Operation(summary = "챌린지 즐겨찾기 추가")
    @PostMapping("user/{userNo}/challenge-favorite")
    @ResponseStatus(HttpStatus.CREATED)
    public ChallengeFavoriteAddResponseDTO addFavoriteList(@PathVariable long userNo,
                                                           @RequestBody ChallengeFavoriteRegistDTO favoriteRegistDTO){

        log.info("try to add challenge-favorite, userNo:{}, challengeId:{}",
                userNo, favoriteRegistDTO.getChallengeId());
        ChallengeFavoriteAddServiceDTO challengeFavoriteAddInfo =
                new ChallengeFavoriteAddServiceDTO(
                        userNo, favoriteRegistDTO.getChallengeId(),
                        LocalDateTime.now()
                );

        return new ChallengeFavoriteAddResponseDTO(
                challengeFavoriteService.addFavorite(challengeFavoriteAddInfo)
        );

    }

    @Operation(summary = "챌린지 즐겨찾기 삭제")
    //@DeleteMapping("user/{userNo}/challenge-favorite/{challengeId}")
    @DeleteMapping("challenge-favorite/{favoriteId}")
    //public void deleteFavorite(@PathVariable long userNo, @PathVariable long challengeId) {
    public void deleteFavorite(@PathVariable long favoriteId){
        ChallengeFavoriteDeleteDTO deleteInfo =
                new ChallengeFavoriteDeleteDTO(favoriteId);

        //log.info("try to delete challenge-favorite, userNo:{}, challengeId:{}",userNo, challengeId);
        log.info("try to delete challenge-favorite, favoriteId:{}",favoriteId);
        challengeFavoriteService.deleteFavorite(deleteInfo);
        //challengeFavoriteService.deleteFavoriteByUserAndChallenge(userNo, challengeId);
    }


    //@Operation(summary = "챌린지 즐겨찾기 삭제")
//    @DeleteMapping("user/{userNo}/challenge-favorite/{challengeId}")
//    public void deleteFavoriteByUserAndChallenge(
//            @PathVariable long userNo,
//            @PathVariable long challengeId
//    ) {
//        log.info("try to delete challenge-favorite, userNo:{}, challengeId:{}",userNo, challengeId);
//        challengeFavoriteService.deleteFavoriteByUserAndChallenge(userNo, challengeId);
//
//    }

    @Operation(summary = "챌린지 즐겨찾기 이름으로 삭제")
    @DeleteMapping("user/{userNo}/challenge-favorite/{challengeName}")
    public void deleteFavorite(@PathVariable long userNo, @PathVariable String challengeName){
        log.info("try to delete challenge-favorite, userNo:{}, challengeId:{}",userNo, challengeName);
        challengeFavoriteService.deleteFavoriteByUserAndChallengeName(userNo, challengeName);
    }

    @Operation(summary = "모션 챌린지 좋아요 추가")
    @PostMapping("user/{userNo}/motion-challenge-like")
    @ResponseStatus(HttpStatus.CREATED)
    public MotionChallengeLikeResponseDTO addMotionLike(@PathVariable long userNo,
                                                        @RequestBody ChallengeFavoriteRegistDTO challengeFavoriteRegist){

        ChallengeFavoriteAddServiceDTO challengeFavoriteAddInfo =
                new ChallengeFavoriteAddServiceDTO(
                        userNo, challengeFavoriteRegist.getChallengeId(),
                        LocalDateTime.now()
                );

        return new MotionChallengeLikeResponseDTO(
                motionChallengeLikeService.addLike(challengeFavoriteAddInfo)
        );
    }

    @Operation(summary = "모션 챌린지 좋아요 취소")
    @DeleteMapping("motion-challenge-like/{favoriteId}")
    public void cancelMotionLike(@PathVariable long favoriteId){
        ChallengeFavoriteDeleteDTO deleteInfo =
                new ChallengeFavoriteDeleteDTO(favoriteId);

        challengeFavoriteService.deleteFavorite(deleteInfo);
    }



}
