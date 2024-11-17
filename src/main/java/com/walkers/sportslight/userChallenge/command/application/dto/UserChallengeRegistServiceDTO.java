package com.walkers.sportslight.userChallenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@ToString
public class UserChallengeRegistServiceDTO {
    private final long userNo;
    private final long challengeId;
    private final int record;
    private final LocalDateTime participateTime;
}
