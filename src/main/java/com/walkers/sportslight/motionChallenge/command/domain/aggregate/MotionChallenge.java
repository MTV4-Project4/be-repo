package com.walkers.sportslight.motionChallenge.command.domain.aggregate;

import com.walkers.sportslight.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table
@Getter
public class MotionChallenge extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long motionChallengeId;

    private String challengeName;
    private long uploaderNo;
    private String content;
    private String motionFileUrl;
    private int participateCount;

    @Builder
    public MotionChallenge(String challengeName, long uploaderNo, String content) {
        this.challengeName = challengeName;
        this.uploaderNo = uploaderNo;
        this.content = content;
        this.participateCount =0;
    }

    public void setMotionFileUrl(String motionFileUrl) {
        this.motionFileUrl = motionFileUrl;
    }

    public void updateParticipateNumber(int participateNumber) {
        this.participateCount += participateNumber;
    }
}
