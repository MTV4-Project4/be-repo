package com.walkers.sportslight.challengeFavorites.query.service;

import com.walkers.sportslight.challengeFavorites.query.dto.UserFavoriteDTO;
import com.walkers.sportslight.challengeFavorites.query.repository.ChallengeFavoriteQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class ChallengeFavoriteQueryService {

    private ChallengeFavoriteQueryRepository challengeFavoriteQueryRepository;

    public ChallengeFavoriteQueryService(ChallengeFavoriteQueryRepository challengeFavoriteQueryRepository) {
        this.challengeFavoriteQueryRepository = challengeFavoriteQueryRepository;
    }

    public UserFavoriteDTO findUserFavorite(long userNo) {
        return challengeFavoriteQueryRepository.findByUserNo(userNo);
    }
}
