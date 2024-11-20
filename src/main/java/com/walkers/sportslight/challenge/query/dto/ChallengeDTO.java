package com.walkers.sportslight.challenge.query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ChallengeDTO {
    private long challengeId;
    private String challengeName;
    private String content;
    private int timeLimit;
    private int participantCount;
    private int capacity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiresAt;

    private Long uploaderNo;
    private String placeName;
    private double longitude;
    private double latitude;
}
