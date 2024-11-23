package com.walkers.sportslight.challenge.domain.repository;

import com.walkers.sportslight.challenge.domain.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findChallengeByChallengeName(String challengeName);
}
