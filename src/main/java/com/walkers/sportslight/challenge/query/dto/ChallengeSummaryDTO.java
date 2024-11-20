package com.walkers.sportslight.challenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChallengeSummaryDTO {

    private long challengeId;
    private String challengeName;
    private String timeLimit;
    private String content;

}
