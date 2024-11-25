package com.walkers.sportslight.challenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ChallengeRewardResponseDTO {
    private long challengeId;
    private String placeName;
    private String rewardName;
    private String rewardBrand;
    private String rewardImagePath;
    private String rewardDescription;
}
