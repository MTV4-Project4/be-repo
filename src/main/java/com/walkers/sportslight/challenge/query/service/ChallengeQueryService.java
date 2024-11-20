package com.walkers.sportslight.challenge.query.service;

import com.walkers.sportslight.challenge.query.dto.*;
import com.walkers.sportslight.challenge.query.repository.ChallengeQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ChallengeQueryService {

    private ChallengeQueryRepository challengeQueryRepository;

    public ChallengeQueryService(ChallengeQueryRepository challengeQueryRepository) {
        this.challengeQueryRepository = challengeQueryRepository;
    }

    public ChallengeIntroDTO findChallengeInfoById(long challengeId){
        return challengeQueryRepository.findChallengeInfoById(challengeId)
                .orElseThrow(()-> new NoSuchElementException("해당하는 챌랜지가 존재하지 않습니다."));
    }

    public List<ChallengeSpotResponseDTO> findChallengeSpotList() {

        return challengeQueryRepository.findChallengeSpotList();

    }

    public ChallengeRankingResponseDTO findChallengeRankingById(long challengeId){
        return challengeQueryRepository.findChallengeRankById(challengeId);
    }

    public ChallengeSummaryDTO findChallengeSummaryById(long challengeId){
        return challengeQueryRepository.findChallengeSummaryById(challengeId);
    }

    public ChallengeRewardResponseDTO findChallengeRewardById(long challengeId) {
        return challengeQueryRepository.findChallengeRewardById(challengeId);
    }

    public ChallengeDTO findChallengeById(long challengeId) {
        return challengeQueryRepository.findChallengeById(challengeId);
    }
}
