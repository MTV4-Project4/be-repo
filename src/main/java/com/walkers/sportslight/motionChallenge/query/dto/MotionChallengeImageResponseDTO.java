package com.walkers.sportslight.motionChallenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MotionChallengeImageResponseDTO {
    private long motionChallengeId;
    private String motionFileUrl;

}
