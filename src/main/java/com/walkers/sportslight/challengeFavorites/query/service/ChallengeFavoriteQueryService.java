package com.walkers.sportslight.challengeFavorites.query.service;

import com.walkers.sportslight.challengeFavorites.query.dto.ChallengeFavoriteDTO;
import com.walkers.sportslight.challengeFavorites.query.repository.ChallengeFavoriteQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeFavoriteQueryService {

    private ChallengeFavoriteQueryRepository challengeFavoriteQueryRepository;

    public ChallengeFavoriteQueryService(ChallengeFavoriteQueryRepository challengeFavoriteQueryRepository) {
        this.challengeFavoriteQueryRepository = challengeFavoriteQueryRepository;
    }

    public List<ChallengeFavoriteDTO> findUserFavorite(long userNo) {
        return challengeFavoriteQueryRepository.findByUserNo(userNo);
    }
}
