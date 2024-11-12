package com.walkers.sportslight.userStat.query.repository;

import com.walkers.sportslight.userStat.query.dto.UserStatDTO;
import com.walkers.sportslight.userStat.query.dto.UserStatResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserStatQueryRepository {

    //UserStatQueryDTO findJsonStatByUserNo(long userNo);

    //List<UserStatResponseDTO> findByUserNo(long userNo);

    //List<UserStatDTO> getPlayerStats(long userNo);

    List<UserStatDTO> getUserStats(long userNo);
}
