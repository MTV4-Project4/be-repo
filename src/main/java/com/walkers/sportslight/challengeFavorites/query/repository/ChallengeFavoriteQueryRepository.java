package com.walkers.sportslight.challengeFavorites.query.repository;

import com.walkers.sportslight.challengeFavorites.query.dto.ChallengeFavoriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChallengeFavoriteQueryRepository {
    List<ChallengeFavoriteDTO> findByUserNo(long userNo);
}
