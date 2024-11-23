package com.walkers.sportslight.motionChallenge.query.repository;

import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeContentResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeImageResponseDTO;
import com.walkers.sportslight.motionChallenge.query.dto.MotionChallengeResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MotionChallengeQueryRepository {

    List<MotionChallengeResponseDTO> findMotionChallenges();

    MotionChallengeContentResponseDTO findMotionChallengeContent(long motionChallengeId);

    MotionChallengeResponseDTO findMotionChallengeById(long challengeId);

    MotionChallengeImageResponseDTO findMotionChallengeImageById(long motionChallengeId);
}
