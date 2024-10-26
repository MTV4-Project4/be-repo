package com.walkers.sportslight.experience.command.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
    public Experience(Long level, Integer requireExperience) {
        this.level = level;
        this.requireExperience = requireExperience;
    }

    public void setRequireExperience(Integer requireExperience) {
        this.requireExperience = requireExperience;
    }
}
