package com.walkers.sportslight.challenge.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//화면정의서 8,9
public class ChallengeSpotResponseDTO {
    private long challengeId;
    private String rewardImagePath;
    private String placeName;
    private double latitude;
    private double longitude;
    private LocalDateTime expiresAt;
}
