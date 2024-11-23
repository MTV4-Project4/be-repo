package com.walkers.sportslight.userChallenge.query.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserChallengeSearchDTO {
    private final long userNo;
    private final long challengeId;
}
