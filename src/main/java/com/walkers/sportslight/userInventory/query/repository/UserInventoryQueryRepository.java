package com.walkers.sportslight.userInventory.query.repository;

import com.walkers.sportslight.userInventory.query.dto.UserInventoryListDTO;
import com.walkers.sportslight.userInventory.query.dto.UserInventoryResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInventoryQueryRepository {

    UserInventoryResponseDTO findByUserNo(long userNo);


}
