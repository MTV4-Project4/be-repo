package com.walkers.sportslight.motionChallenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MotionChallengeContentResponseDTO {
    private long motionChallengeId;
    private String motionChallengeName;
    private String content;
}
