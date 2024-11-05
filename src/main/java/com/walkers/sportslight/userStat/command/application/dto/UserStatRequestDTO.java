package com.walkers.sportslight.userStat.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserStatRequestDTO {
    private final long userNo;
    private final String statType; // 스탯 유형
    private final int statExperience; // 경험치
    private final int value; // 스탯 수치
}
