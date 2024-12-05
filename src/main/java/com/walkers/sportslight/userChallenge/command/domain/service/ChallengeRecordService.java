package com.walkers.sportslight.userChallenge.command.domain.service;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserBestRecord;
import com.walkers.sportslight.userChallenge.command.repository.UserBestRecordRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ChallengeRecordService {

    private UserBestRecordRepository userBestRecordRepository;

    public ChallengeRecordService(UserBestRecordRepository userBestRecordRepository) {
        this.userBestRecordRepository = userBestRecordRepository;
    }

    public boolean isNewRecord(long userNo, long challengeId, int record){

        Optional<UserBestRecord> userBestRecord = userBestRecordRepository.findByUserNoAndChallengeId(
                userNo, challengeId
        );

        return userBestRecord.isEmpty()
                || userBestRecord.get().getRecord() < record;
    }

    public int getCurrentScoreRank(long userNo, long challengeId, int record){
        return 1+userBestRecordRepository.countByChallengeIdAndUserNoNotAndRecordGreaterThanEqual(
                challengeId, userNo, record
        );
    }

}
