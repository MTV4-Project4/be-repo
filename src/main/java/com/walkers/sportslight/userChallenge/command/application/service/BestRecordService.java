package com.walkers.sportslight.userChallenge.command.application.service;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserBestRecord;
import com.walkers.sportslight.userChallenge.command.repository.UserBestRecordRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class BestRecordService {

    private UserBestRecordRepository userBestRecordRepository;

    public BestRecordService(UserBestRecordRepository userBestRecordRepository) {
        this.userBestRecordRepository = userBestRecordRepository;
    }

    public UserBestRecord findBestRecordOrNullByUserNoAndChallengeId(
            long userNo, long challengeId
    ){
        return userBestRecordRepository.findByUserNoAndChallengeId(userNo, challengeId)
                .orElse(new UserBestRecord(userNo,challengeId, 0, LocalDateTime.now()));
    }

    @Transactional
    public void updateBestRecord(Long userNo, Long challengeId, int record,
                                 LocalDateTime participateTime){
        UserBestRecord bestRecord = userBestRecordRepository.findByUserNoAndChallengeId(userNo, challengeId)
                .orElse(new UserBestRecord(userNo, challengeId, record, participateTime));
        userBestRecordRepository.save(bestRecord);


    }
}
