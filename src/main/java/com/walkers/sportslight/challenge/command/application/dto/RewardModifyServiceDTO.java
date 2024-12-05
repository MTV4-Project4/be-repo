package com.walkers.sportslight.challenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Getter
public class RewardModifyServiceDTO {
    private final long challengeId;
    private final String rewardName;
    private final String rewardBrand;
    private final String rewardDescription;
    private final MultipartFile rewardImage;
    private final String isChecked="N";
}
