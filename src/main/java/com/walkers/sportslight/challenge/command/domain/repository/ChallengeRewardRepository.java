package com.walkers.sportslight.challenge.command.domain.repository;

import com.walkers.sportslight.challenge.command.domain.model.ChallengeReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRewardRepository extends JpaRepository<ChallengeReward, Long> {
}
