package com.walkers.sportslight.userChallenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserChallengeDeleteDTO {
    private final long userNo;
    private final long userChallengeId;
}
