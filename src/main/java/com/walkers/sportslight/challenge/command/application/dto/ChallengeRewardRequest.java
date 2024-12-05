package com.walkers.sportslight.challenge.command.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
@ToString
public class ChallengeRewardRequest {
    private final String rewardName;
    private final String rewardBrand;
    private final String rewardDescription;
    private final MultipartFile rewardImage;
}
