package com.walkers.sportslight.userStat.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengeExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long challengeExperienceId;

    private long challengeId;
    private int ranking;

    @Enumerated(EnumType.STRING)
    private StatType statType;
    private int experience;

}
