package com.walkers.sportslight.userMatch.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userMatchId;

    private long challengeId;

    private long user1Id;
    private int user1Score;
    
    private long user2Id;
    private int user2Score;

    private LocalDateTime matchTime;

    @Builder
    public UserMatch(long challengeId, long user1Id, int user1Score, long user2Id, int user2Score, LocalDateTime matchTime) {
        this.challengeId = challengeId;
        this.user1Id = user1Id;
        this.user1Score = user1Score;
        this.user2Id = user2Id;
        this.user2Score = user2Score;
        this.matchTime = matchTime;
    }
}
