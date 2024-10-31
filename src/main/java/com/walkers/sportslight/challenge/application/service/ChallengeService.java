package com.walkers.sportslight.challenge.application.service;

import com.walkers.sportslight.challenge.application.dto.ChallengeMapper;
import com.walkers.sportslight.challenge.application.dto.ChallengeRequest;
import com.walkers.sportslight.challenge.domain.model.Challenge;
import com.walkers.sportslight.challenge.domain.repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ChallengeService {

    private ChallengeRepository challengeRepository;
    private ChallengeMapper challengeMapper;

    public ChallengeService(ChallengeRepository challengeRepository, ChallengeMapper challengeMapper) {
        this.challengeRepository = challengeRepository;
        this.challengeMapper = challengeMapper;
    }

    private Challenge findChallenge(long challengeId){
        return challengeRepository.findById(challengeId)
                .orElseThrow(
                        ()-> new NoSuchElementException("해당 챌린지를 찾을 수 없습니다.")
                );
    }


    public void addChallenge(ChallengeRequest challengeRequest) {
        Challenge challenge = challengeMapper.toChallenge(challengeRequest);
        challengeRepository.save(challenge);

    }

    public void deleteChallenge(long challengeId) {
        challengeRepository.deleteById(challengeId);
    }

    public void updateChallenge(long challengeId, ChallengeRequest challengeUpdate) {
        Challenge challenge = findChallenge(challengeId);


    }
}
