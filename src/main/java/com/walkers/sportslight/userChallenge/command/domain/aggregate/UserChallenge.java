package com.walkers.sportslight.userChallenge.command.domain.aggregate;

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
public class UserChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserChallengeId;

    private long userNo;
    private long challengeId;
    private int record;
    private LocalDateTime participateTime;

    @Builder
    public UserChallenge(long userNo, long challengeId, int record, LocalDateTime participateTime) {
        this.userNo = userNo;
        this.challengeId = challengeId;
        this.record = record;
        this.participateTime = participateTime;
    }

    public void update(int record, LocalDateTime participateTime){
        if (record<=this.record){
            return;
        }

        this.record = record;
        this.participateTime = participateTime;
    }
}
