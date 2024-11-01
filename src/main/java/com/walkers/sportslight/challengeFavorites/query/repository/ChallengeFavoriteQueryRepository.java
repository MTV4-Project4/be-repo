package com.walkers.sportslight.challengeFavorites.query.repository;

import com.walkers.sportslight.challengeFavorites.query.dto.UserFavoriteDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChallengeFavoriteQueryRepository {
    UserFavoriteDTO findByUserNo(long userNo);
}
