package com.walkers.sportslight.userMotionChallenge.command.application.dto;

import com.walkers.sportslight.userMotionChallenge.command.domain.aggregate.UserMotionChallenge;
import com.walkers.sportslight.userStat.command.application.dto.UserStatRequestDTO;
import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMotionChallengeMapper {
    UserMotionChallengeMapper INSTANCE = Mappers.getMapper(UserMotionChallengeMapper.class);

    UserMotionChallenge toUserMotionChallenge(UserChallengeAddServiceDTO userChallengeAddInfo);
}
