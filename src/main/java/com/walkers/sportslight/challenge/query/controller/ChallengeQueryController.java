package com.walkers.sportslight.challenge.query.controller;

import com.walkers.sportslight.challenge.query.dto.*;
import com.walkers.sportslight.challenge.query.service.ChallengeQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/challenge")
@Tag(name = "챌린지 조회 API", description = "챌린지 설명, 랭킹, 보상을 조회하는 API")
public class ChallengeQueryController {

    //private final ChallengeService challengeService;
    private ChallengeQueryService challengeQueryService;


    public ChallengeQueryController(ChallengeQueryService challengeQueryService) {
        this.challengeQueryService = challengeQueryService;
    }

    @Operation(summary = "챌린지 정보 조회")
    @GetMapping("{challengeId}")
    public ChallengeDTO getChallenge(@PathVariable long challengeId){
        return challengeQueryService.findChallengeById(challengeId);
    }

    @Operation(summary = "챌린지 소개 조회", description = "현재 1등 유저를 포함한 챌린지 정보")
    @GetMapping("{challengeId}/intro")
    public ChallengeIntroDTO getChallengeInfo(@PathVariable long challengeId){
        return challengeQueryService.findChallengeInfoById(challengeId);
    }

    @Operation(summary = "챌린지 보상 조회")
    @GetMapping("{challengeId}/reward")
    public ChallengeRewardResponseDTO getChallengeReward(@PathVariable long challengeId) {
        return challengeQueryService.findChallengeRewardById(challengeId);
    }

    @Operation(summary = "챌린지 랭킹 조회")
    @GetMapping("{challengeId}/rank")
    public ChallengeRankingResponseDTO getChallengeRanking(@PathVariable long challengeId){
        return challengeQueryService.findChallengeRankingById(challengeId);
    }

    @Operation(summary = "챌린지 요약 정보 조회")
    @GetMapping("{challengeId}/summary")
    public ChallengeSummaryDTO getChallengeSummary(@PathVariable long challengeId) {
        return challengeQueryService.findChallengeSummaryById(challengeId);
    }


}
