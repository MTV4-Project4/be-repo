package com.walkers.sportslight.reward.command.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rewardId;

    private long challengeId;
    private String rewardName;
    private String rewardDescription;
    private String rewardImagePath;

    @Builder
    public Reward(long challengeId, String rewardName, String rewardDescription) {
        this.challengeId = challengeId;
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
    }
}
