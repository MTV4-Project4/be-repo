package com.walkers.sportslight.challenge.application.dto;

import com.walkers.sportslight.challenge.domain.model.ChallengeReward;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChallengeRewardMapper {
    ChallengeRewardMapper INSTANCE = Mappers.getMapper(ChallengeRewardMapper.class);

    //@Mapping(target = "rewardImagePath", ignore = true)
    ChallengeReward toChallengeReward(RewardModifyServiceDTO rewardInfo);
}
