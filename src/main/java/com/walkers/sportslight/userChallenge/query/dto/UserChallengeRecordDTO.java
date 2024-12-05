package com.walkers.sportslight.userChallenge.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserChallengeRecordDTO {
    private long userNo;
    private long challengeId;
    private int ranking;
    private int record;
}
