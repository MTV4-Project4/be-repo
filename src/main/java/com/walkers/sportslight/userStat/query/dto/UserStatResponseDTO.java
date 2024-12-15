package com.walkers.sportslight.userStat.query.dto;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class UserStatResponseDTO {
    private StatType statType;
    private int value;
    private int statExperience;
}
