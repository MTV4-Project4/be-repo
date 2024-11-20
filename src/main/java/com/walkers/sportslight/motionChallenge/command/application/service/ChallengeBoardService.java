package com.walkers.sportslight.motionChallenge.command.application.service;

import com.walkers.sportslight.motionChallenge.command.domain.aggregate.MotionChallenge;
import com.walkers.sportslight.motionChallenge.command.domain.repository.MotionChallengeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class ChallengeBoardService {

    private MotionChallengeRepository motionChallengeRepository;

    public ChallengeBoardService(MotionChallengeRepository motionChallengeRepository) {
        this.motionChallengeRepository = motionChallengeRepository;
    }

    @Transactional
    public long addMotionChallengeBoard(MotionChallenge motionChallenge, String filePath, String fileUrl){
        motionChallenge.setMotionFileUrl(fileUrl);
        return motionChallengeRepository.save(motionChallenge).getMotionChallengeId();
    }

    @Transactional
    public void deleteMotionChallengeBoard(long motionChallengeId){
        motionChallengeRepository.deleteById(motionChallengeId);
    }

    @Transactional
    public void setImage(long challengeId, String fileUploadUrl){
        MotionChallenge motionChallenge =  motionChallengeRepository.findById(challengeId)
                .orElseThrow(()-> new NoSuchElementException("해당하는 모션 챌린지가 존재하지 않습니다."));

        motionChallenge.setMotionFileUrl(fileUploadUrl);
        //log.info("바뀐건가? url:{}", motionChallenge.getMotionFileUrl());

    }



}
