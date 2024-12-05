package com.walkers.sportslight.challenge.command.application.dto;

import com.walkers.sportslight.challenge.command.domain.model.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {
    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);

    //@Mapping(target = "rewardImage", ignore = true)
    Challenge toChallenge(ChallengeAddRequest challengeAddRequest);

}
