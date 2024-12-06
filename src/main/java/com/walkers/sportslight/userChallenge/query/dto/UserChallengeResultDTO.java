package com.walkers.sportslight.userChallenge.query.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChallengeResultDTO {
    private long userChallengeId;
    private int prevRecord;
    private int currentRecord;
    private int ranking;
}
