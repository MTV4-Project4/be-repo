package com.walkers.sportslight.motionChallenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
@ToString
public class MotionChallengeImageSetDTO {
    private final MultipartFile file;
}
