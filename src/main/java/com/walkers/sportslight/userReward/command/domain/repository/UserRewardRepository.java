package com.walkers.sportslight.userReward.command.domain.repository;

import com.walkers.sportslight.userReward.command.domain.aggregate.UserReward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRewardRepository extends JpaRepository<UserReward, Long> {
}
