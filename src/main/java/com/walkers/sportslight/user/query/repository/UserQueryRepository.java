package com.walkers.sportslight.user.query.repository;

import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.query.dto.AccountInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserQueryRepository {
    Optional<AccountInfoResponseDTO> findAccountByUserNo(long userNo);


}
