package com.walkers.sportslight.userChallenge.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class UserChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userChallengeId;

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
