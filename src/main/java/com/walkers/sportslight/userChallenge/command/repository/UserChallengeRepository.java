package com.walkers.sportslight.userChallenge.command.repository;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {
    Optional<UserChallenge> findByUserNoAndChallengeId(Long UserNo, Long ChallengeId);

    // 같은 챌린지에서 입력된 기록보다 크거나 같은 기록의 갯수
    // 즉 현재 기록이 몇등인지를 반환
    int countByChallengeIdAndRecordGreaterThanEqual(long challengeId, int record);
}
