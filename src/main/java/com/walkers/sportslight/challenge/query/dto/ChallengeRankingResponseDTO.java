package com.walkers.sportslight.challenge.query.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChallengeRankingResponseDTO {
    private long challengeId;
    private String placeName;
    private String challengeName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiresAt;
    private int timeLimit;
    private List<UserRank> userRank;
}
