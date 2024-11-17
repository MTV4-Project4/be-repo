package com.walkers.sportslight.userChallenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class UserChallengeDetail {
    private long UserChallengeId;
    private long userNo;
    private long challengeId;
    private String nickname;
    private int record;
    private int ranking;
    private LocalDateTime participateTime;
}
