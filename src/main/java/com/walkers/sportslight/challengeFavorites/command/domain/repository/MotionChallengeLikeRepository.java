package com.walkers.sportslight.challengeFavorites.command.domain.repository;


import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.MotionChallengeLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotionChallengeLikeRepository extends JpaRepository<MotionChallengeLike, Long> {
    void deleteByUserNoAndMotionChallengeId(long userNo, long motionChallengeId);

    boolean existsByUserNoAndMotionChallengeId(long userNo, long challengeId);
}
