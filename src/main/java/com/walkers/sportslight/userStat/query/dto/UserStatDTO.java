package com.walkers.sportslight.userStat.query.dto;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserStatDTO {
    private StatType statType; // 스탯 유형 (Enum)
    private int statLevel;      // 스탯 레벨
    private int statExperience; // 스탯 경험치

}

