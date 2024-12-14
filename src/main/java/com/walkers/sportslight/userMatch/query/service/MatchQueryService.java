package com.walkers.sportslight.userMatch.query.service;

import com.walkers.sportslight.userMatch.query.dto.MatchResultUserDTO;
import com.walkers.sportslight.userMatch.query.repository.MatchQueryRepository;

import java.util.List;

public class MatchQueryService {

    private MatchQueryRepository matchQueryRepository;

    public List<MatchResultUserDTO> findResultByMatchId(long matchId){
        return matchQueryRepository.findResultByMatchId(matchId);
    }


}
