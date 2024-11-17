package com.walkers.sportslight.userMotionChallenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
public class UserChallengeAddServiceDTO {
    private final long userNo;
    private final long motionChallengeNo;
    private final MultipartFile addImage;
}
