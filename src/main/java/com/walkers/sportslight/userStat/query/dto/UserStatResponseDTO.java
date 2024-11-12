package com.walkers.sportslight.userStat.query.dto;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserStatResponseDTO {
    private StatType statType;
    private int value;
    private int statExperience;
}
