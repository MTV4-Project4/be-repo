package com.walkers.sportslight.challenge.application.service;

import com.walkers.sportslight.challenge.application.dto.ChallengeMapper;
import com.walkers.sportslight.challenge.application.dto.ChallengeAddRequest;
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

    public Long findChallengeIdByName(String challengeName){
        Challenge challenge = challengeRepository.findChallengeByChallengeName(challengeName)
                .orElse(
                        null
                );
        if(challenge==null){
            return null;
        } else{
            return challenge.getChallengeId();
        }
    }

    public long addChallenge(ChallengeAddRequest challengeAddRequest) {
        Challenge challenge = challengeMapper.toChallenge(challengeAddRequest);
        Challenge registedChallenge = challengeRepository.save(challenge);
        return registedChallenge.getChallengeId();

    }

    public void deleteChallenge(long challengeId) {
        challengeRepository.deleteById(challengeId);
    }

    public void updateChallenge(long challengeId, ChallengeAddRequest challengeUpdate) {
        Challenge challenge = findChallenge(challengeId);


    }
}
