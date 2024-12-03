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
// 조회 쿼리 단순화를 위해 집계 테이블로 사용
public class UserBestRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bestRecordId;

    private long userNo;
    private long challengeId;
    private int record;
    private LocalDateTime participateTime;

    public UserBestRecord(long userNo, long challengeId, int record, LocalDateTime participateTime) {
        this.userNo = userNo;
        this.challengeId = challengeId;
        this.record = record;
        this.participateTime = participateTime;
    }

    public void updateChallengeRecord(
            int record, LocalDateTime participateTime
    ){
        if (this.record>=record){
            return ;
        }

        this.record = record;
        this.participateTime = participateTime;
    }
}
