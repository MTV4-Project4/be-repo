package com.walkers.sportslight.userChallenge.query.repository;

import com.walkers.sportslight.userChallenge.query.dto.UserChallengeResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserChallengeQueryRepository {

    List<UserChallengeResponseDTO> findByUserNo(long userNo);

}
