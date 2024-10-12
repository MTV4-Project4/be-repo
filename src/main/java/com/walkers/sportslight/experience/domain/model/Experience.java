package com.walkers.sportslight.experience.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Experience {

    @Id
    private Long level;
    private String isMaxLevel;
    private Integer requireExperience;

    public Experience(Long level, String isMaxLevel, Integer requireExperience) {
        this.level = level;
        this.isMaxLevel = isMaxLevel;
        this.requireExperience = requireExperience;
    }
}
