package com.walkers.sportslight.userMatch.query.repository;

import com.walkers.sportslight.userMatch.query.dto.MatchProfileDTO;
import com.walkers.sportslight.userMatch.query.dto.MatchResultUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MatchQueryRepository {
    List<MatchResultUserDTO> findResultByMatchId(long matchId);

    MatchProfileDTO findProfileByUserNo(long userNo);
}
