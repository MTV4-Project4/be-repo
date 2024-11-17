package com.walkers.sportslight.challenge.domain.repository;

import com.walkers.sportslight.challenge.domain.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
