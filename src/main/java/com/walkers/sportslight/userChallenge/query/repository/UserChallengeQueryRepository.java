package com.walkers.sportslight.userChallenge.query.repository;

import com.walkers.sportslight.userChallenge.query.dto.UserChallengeRecordDTO;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeResponseDTO;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeResultDTO;
import com.walkers.sportslight.userChallenge.query.dto.UserChallengeSearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserChallengeQueryRepository {

    List<UserChallengeResponseDTO> findByUserNo(long userNo);

    UserChallengeRecordDTO findUserChallengeRank(UserChallengeSearchDTO userChallengeSearchInfo);

    UserChallengeResultDTO findUserChallengeResult(long userChallengeId);
}
