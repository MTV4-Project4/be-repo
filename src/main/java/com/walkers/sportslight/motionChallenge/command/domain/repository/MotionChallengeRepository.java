package com.walkers.sportslight.motionChallenge.command.domain.repository;

import com.walkers.sportslight.motionChallenge.command.domain.aggregate.MotionChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotionChallengeRepository extends JpaRepository<MotionChallenge, Long> {
}
