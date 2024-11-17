package com.walkers.sportslight.userStat.command.domain.aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Experience {

    @Id
    private Long level;
    private Integer requireExperience;

    public Experience(Long level, Integer requireExperience) {
        this.level = level;
        this.requireExperience = requireExperience;
    }
}
