package com.walkers.sportslight.userChallenge.query.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserChallengeDetail {
    private long UserChallengeId;
    private long userNo;
    private long challengeId;
    private String nickname;
    private int record;
    private int ranking;
    private LocalDateTime participateTime;
}
