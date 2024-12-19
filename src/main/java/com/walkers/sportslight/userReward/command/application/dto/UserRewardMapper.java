package com.walkers.sportslight.userReward.command.application.dto;

import com.walkers.sportslight.userReward.command.domain.aggregate.UserReward;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRewardMapper {
    UserRewardMapper INSTANCE = Mappers.getMapper(UserRewardMapper.class);

    UserReward toUserReward(UserRewardDTO userRewardInfo);
}
