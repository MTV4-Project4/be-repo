package com.walkers.sportslight.userChallenge.command.application.dto;

import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserChallengeMapper {
    UserChallengeMapper INSTANCE = Mappers.getMapper(UserChallengeMapper.class);

    UserChallenge toUserChallenge(UserChallengeRegistServiceDTO userRegistInfo);

}
