package com.walkers.sportslight.userChallenge.query.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor  // 기본 생성자 추가
@Getter
@Setter  // setter 추가
public class UserChallengeResponseDTO {
    private long userChallengeId;
    private long challengeId;
    private String challengeName;
    private int record;
    private int ranking;
    private LocalDateTime expiresAt;
}
