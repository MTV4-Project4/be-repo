package com.walkers.sportslight.user.query.repository;

import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.query.dto.AccountInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserQueryRepository {
    AccountInfoResponseDTO findAccountByUserNo(long userNo);


}
