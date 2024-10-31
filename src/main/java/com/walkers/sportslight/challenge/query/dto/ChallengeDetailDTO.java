package com.walkers.sportslight.challenge.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ChallengeDetailDTO {
    private long challengeId;
    private String challengeName;
    private String challengeDescription;

    private int timeLimit;
    private int participantCount;
    private int capacity;
    private LocalDateTime expiresAt;

    private String firstUserName;
    private Integer firstUserScore;
}
