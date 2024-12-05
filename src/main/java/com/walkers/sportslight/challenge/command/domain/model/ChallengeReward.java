package com.walkers.sportslight.challenge.command.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    private long challengeId;
    private String rewardName;
    private String rewardBrand;
    private String rewardDescription;
    private String rewardImagePath;
    private String isChecked;

    @Builder
    public ChallengeReward(long challengeId, String rewardName, String rewardBrand, String rewardDescription, String isChecked) {
        this.challengeId = challengeId;
        this.rewardName = rewardName;
        this.rewardBrand = rewardBrand;
        this.rewardDescription = rewardDescription;
        this.isChecked = isChecked;
    }

    public void setRewardImagePath(String rewardImagePath) {
        this.rewardImagePath = rewardImagePath;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}
