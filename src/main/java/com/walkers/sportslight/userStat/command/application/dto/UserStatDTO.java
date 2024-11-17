package com.walkers.sportslight.userStat.command.application.dto;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class UserStatDTO {
    private final int addExperience;

    @Positive(message = "업데이트할 스탯 종류를 입력하세요.")
    private final StatType statType;
}
