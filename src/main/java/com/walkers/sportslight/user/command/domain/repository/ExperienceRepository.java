package com.walkers.sportslight.user.command.domain.repository;

import com.walkers.sportslight.userStat.command.domain.aggregate.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository  extends JpaRepository<Experience, Long> {
}
