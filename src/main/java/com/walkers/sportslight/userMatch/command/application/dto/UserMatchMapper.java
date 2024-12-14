package com.walkers.sportslight.userMatch.command.application.dto;

import com.walkers.sportslight.userMatch.command.domain.aggregate.UserMatch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMatchMapper {
    UserMatchMapper INSTANCE = Mappers.getMapper(UserMatchMapper.class);

    UserMatch toUserMatch(UserMatchServiceRequest userMatchServiceRequest);
}
