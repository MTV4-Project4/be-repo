package com.walkers.sportslight.challenge.query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//현재 1등정보를 포함한 dto
public class ChallengeIntroDTO {
    private long challengeId;
    private String challengeName;
    private String content;
    private int timeLimit;
    private int participantCount;
    private int capacity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiresAt;
    private long firstUserNo;
    private String firstUserName;
    private Integer firstUserScore;
}
