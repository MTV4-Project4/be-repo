package com.walkers.sportslight.challenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChallengeRewardAddResponseDTO {
    private final long challengeId;
    private final long rewardId;
}
