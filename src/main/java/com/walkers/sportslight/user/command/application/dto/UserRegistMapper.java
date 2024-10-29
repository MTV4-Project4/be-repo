package com.walkers.sportslight.user.command.application.dto;

import com.walkers.sportslight.user.command.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRegistMapper {
    UserRegistMapper INSTANCE = Mappers.getMapper(UserRegistMapper.class);

    User toUser(UserRegistServiceDTO userRegistInfo);
}
