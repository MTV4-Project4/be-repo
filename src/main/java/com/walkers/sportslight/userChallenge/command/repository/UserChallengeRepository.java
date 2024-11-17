package com.walkers.sportslight.userChallenge.command.repository;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {
    Optional<UserChallenge> findByUserNoAndChallengeId(Long UserNo, Long ChallengeId);
}
