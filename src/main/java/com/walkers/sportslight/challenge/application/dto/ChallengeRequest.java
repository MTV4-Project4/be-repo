package com.walkers.sportslight.challenge.application.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ChallengeRequest {
    @NotBlank(message = "챌린지 이름은 필수입니다.")
    private final String challengeName;

    @NotBlank(message = "챌린지 내용은 필수입니다.")
    private final String content;

    @Positive(message = "시간 제한은 양수여야 합니다.")
    private final int timeLimit;

    @Positive(message = "참가자 수는 양수이어야 합니다.")
    private final int capacity; // 허용 참가자 수

    @Future(message = "마감 날짜를 올바르게 설정해주세요.")
    private final LocalDateTime expireAt; // 언제 마감되는지
    
    @Positive
    private final double longitude; // 위도
    @Positive
    private final double latitude; // 경도
    
}
