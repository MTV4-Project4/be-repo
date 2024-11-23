package com.walkers.sportslight.challengeFavorites.command.domain.aggregate;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MotionChallengeLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    private long userNo;
    private long motionChallengeId;
    private LocalDateTime addedDate;

    @Builder
    public MotionChallengeLike(long userNo, long motionChallengeId, LocalDateTime addedDate) {
        this.userNo = userNo;
        this.motionChallengeId = motionChallengeId;
        this.addedDate = addedDate;
    }

}
