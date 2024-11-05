package com.walkers.sportslight.challenge.domain.model;

import com.walkers.sportslight.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long challengeId;

    private String challengeName;
    private String content;
    private long uploaderNo;
    private int timeLimit;
    private int participantCount; // 현재 참가자 수
    private int capacity; // 허용 참가자 수

    @Embedded
    private Coordinate challengeCoords;
    private LocalDateTime expiresAt;

    @Builder
    public Challenge(String challengeName, String content, int timeLimit, int participantCount, int capacity,
                     long uploaderNo, Coordinate challengeCoords, LocalDateTime expiresAt) {
        this.challengeName = challengeName;
        this.content = content;
        this.timeLimit = timeLimit;
        this.participantCount = participantCount;
        this.capacity = capacity;
        this.uploaderNo = uploaderNo;
        this.challengeCoords = challengeCoords;
        this.expiresAt = expiresAt;
    }

    public void update(String challengeName, String content, int timeLimit, int capacity,
                    Coordinate challengeCoords, LocalDateTime expiresAt){
        this.challengeName = challengeName;
        this.content = content;
        this.timeLimit = timeLimit;
        this.capacity = capacity;
        this.challengeCoords = challengeCoords;
        this.expiresAt = expiresAt;
    }

    public int participate(){
        if (participantCount>=capacity){
            throw new RuntimeException("최대 참가자 수를 초과 했습니다.");
        }

        participantCount+=1;
        return participantCount;
    }
}
