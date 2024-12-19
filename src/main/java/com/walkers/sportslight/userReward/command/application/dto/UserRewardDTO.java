package com.walkers.sportslight.userReward.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRewardDTO {
    private final long receiverNo;
    private final String address;
    private final long challengeRewardId;
}
