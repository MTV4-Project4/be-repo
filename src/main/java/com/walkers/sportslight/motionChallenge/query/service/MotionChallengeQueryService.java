package com.walkers.sportslight.motionChallenge.query.service;

import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeContentResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeImageResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeResponseDTO;
import com.walkers.sportslight.motionChallenge.query.repository.MotionChallengeQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotionChallengeQueryService {

    private MotionChallengeQueryRepository motionChallengeQueryRepository;

    public MotionChallengeQueryService(MotionChallengeQueryRepository motionChallengeQueryRepository) {
        this.motionChallengeQueryRepository = motionChallengeQueryRepository;
    }

    public List<MotionChallengeResponseDTO> findMotionChallenges() {
        return motionChallengeQueryRepository.findMotionChallenges();
    }

    public MotionChallengeContentResponseDTO findMotionChallengeContentById(long motionChallengeId) {
        return motionChallengeQueryRepository.findMotionChallengeContent(motionChallengeId);
    }

    public MotionChallengeResponseDTO findMotionChallengeById(long challengeId) {
        return motionChallengeQueryRepository.findMotionChallengeById(challengeId);
    }

    public MotionChallengeImageResponseDTO findMotionChallengeImageById(long motionChallengeId) {
        return motionChallengeQueryRepository.findMotionChallengeImageById(motionChallengeId);
    }
}
