package com.walkers.sportslight.userChallenge.command.repository;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserBestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBestRecordRepository extends JpaRepository<UserBestRecord, Long> {
    Optional<UserBestRecord> findByUserNoAndChallengeId(Long UserNo, Long ChallengeId);

    int countByChallengeIdAndUserNoNotAndRecordGreaterThanEqual(long challengeId, long userNo, int record);
}
