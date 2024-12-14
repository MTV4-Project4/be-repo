package com.walkers.sportslight.motionChallenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MotionChallengeResponseDTO {
    private long motionChallengeId;
    private String motionChallengeName;
    private String content;
    private String motionFileUrl;
    private long uploaderNo;
    private int participateCount;
    private String nickname;
    private int likeCount;
}
