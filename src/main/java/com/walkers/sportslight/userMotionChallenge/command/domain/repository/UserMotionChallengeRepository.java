package com.walkers.sportslight.userMotionChallenge.command.domain.repository;

import com.walkers.sportslight.userMotionChallenge.command.domain.aggregate.UserMotionChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMotionChallengeRepository extends JpaRepository<UserMotionChallenge, Long> {

}
