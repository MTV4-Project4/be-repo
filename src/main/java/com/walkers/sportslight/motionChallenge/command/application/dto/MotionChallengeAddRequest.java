package com.walkers.sportslight.motionChallenge.command.application.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
@ToString
public class MotionChallengeAddRequest {

    @NotBlank(message = "챌린지 이름을 입력하세요.")
    private final String challengeName;

    @NotNull(message = "유저번호를 입력하세요")
    @Positive(message = "올바른 유저번호를 입력하세요")
    private final long uploaderNo;
    
    @NotBlank(message = "챌린지 설명을 입력하세요")
    private final String content;
    private final MultipartFile file;

}
