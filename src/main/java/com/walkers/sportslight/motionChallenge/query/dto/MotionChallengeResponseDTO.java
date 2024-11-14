package com.walkers.sportslight.motionChallenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MotionChallengeResponseDTO {
    private long motionChallengeId;
    private String motionChallengeName;
    private String content;
    private String motionFileUrl;
    private long uploaderNo;
    private int participateCount;
    private String nickname;
}
