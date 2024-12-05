package com.walkers.sportslight.challenge.command.application.controller;

import com.walkers.sportslight.challenge.command.application.dto.ChallengeRewardAddResponseDTO;
import com.walkers.sportslight.challenge.command.application.dto.ChallengeRewardRequest;
import com.walkers.sportslight.challenge.command.application.dto.RewardModifyServiceDTO;
import com.walkers.sportslight.challenge.command.application.service.ChallengeRewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/challenge")
@Slf4j
public class ChallengeRewardController {

    private ChallengeRewardService challengeRewardService;

    public ChallengeRewardController(ChallengeRewardService challengeRewardService) {
        this.challengeRewardService = challengeRewardService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{challengeId}/reward")
    public ChallengeRewardAddResponseDTO addReward(@PathVariable long challengeId,
                                                   @ModelAttribute ChallengeRewardRequest challengeRewardRequest){
        log.debug("to add challengeReward, challengeId:{}, rewardInfo:{}", challengeId, challengeRewardRequest);
        long rewardId = challengeRewardService.addReward(new RewardModifyServiceDTO(
                challengeId,
                challengeRewardRequest.getRewardName(),
                challengeRewardRequest.getRewardBrand(),
                challengeRewardRequest.getRewardDescription(),
                challengeRewardRequest.getRewardImage()
                )
        );
        return new ChallengeRewardAddResponseDTO(challengeId, rewardId);
    }
}
