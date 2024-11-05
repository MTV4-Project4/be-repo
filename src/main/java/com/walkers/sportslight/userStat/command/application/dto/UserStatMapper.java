package com.walkers.sportslight.userStat.command.application.dto;

import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserStatMapper {
    UserStatMapper INSTANCE = Mappers.getMapper(UserStatMapper.class);

    UserStat toUserStat(UserStatRequestDTO userStatRequest);
}
