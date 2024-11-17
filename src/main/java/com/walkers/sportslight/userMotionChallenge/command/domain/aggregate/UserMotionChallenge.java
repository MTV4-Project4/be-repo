package com.walkers.sportslight.userMotionChallenge.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMotionChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMotionId;

    private long userNo;
    private long motionChallengeId;
    private String userMotionFileUrl;
    private double similarity;


    @Builder
    public UserMotionChallenge(long userNo, long motionChallengeId) {
        this.userNo = userNo;
        this.motionChallengeId = motionChallengeId;
    }

    public void setUserMotionFileUrl(String userMotionFileUrl) {
        this.userMotionFileUrl = userMotionFileUrl;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
}
