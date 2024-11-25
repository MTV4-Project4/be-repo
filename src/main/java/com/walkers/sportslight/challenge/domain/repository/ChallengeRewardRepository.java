package com.walkers.sportslight.challenge.domain.repository;

import com.walkers.sportslight.challenge.domain.model.ChallengeReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRewardRepository extends JpaRepository<ChallengeReward, Long> {
}
