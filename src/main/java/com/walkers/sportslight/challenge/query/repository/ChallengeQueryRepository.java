package com.walkers.sportslight.challenge.query.repository;

import com.walkers.sportslight.challenge.query.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChallengeQueryRepository {

    Optional<ChallengeIntroDTO> findChallengeInfoById(long challengeId);

    List<ChallengeSpotResponseDTO> findChallengeSpotList();

    ChallengeRankingResponseDTO findChallengeRankById(long challengeId);

    ChallengeSummaryDTO findChallengeSummaryById(long challengeId);

    ChallengeRewardResponseDTO findChallengeRewardById(long challengeId);

    ChallengeDTO findChallengeById(long challengeId);
}
