package com.walkers.sportslight.challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ChallengeAddRequest {
    @NotBlank(message = "챌린지 이름은 필수입니다.")
    private final String challengeName;

    @NotBlank(message = "챌린지 내용은 필수입니다.")
    private final String content;

    @Positive(message = "시간 제한은 양수여야 합니다.")
    private final int timeLimit;

    @Positive(message = "참가자 수는 양수이어야 합니다.")
    private final int capacity=50; // 허용 참가자 수

    private Long uploaderNo;

    @Future(message = "마감 날짜를 올바르게 설정해주세요.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime expiresAt; // 언제 마감되는지

    private final String placeName;
    @Positive
    private final double longitude; // 위도
    @Positive
    private final double latitude; // 경도

    @JsonIgnore
    private int participantCount=0;
}
