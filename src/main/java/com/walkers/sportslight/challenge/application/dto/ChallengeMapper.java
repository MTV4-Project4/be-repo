package com.walkers.sportslight.challenge.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walkers.sportslight.challenge.domain.model.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {
    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);

    //@Mapping(target = "rewardImage", ignore = true)
    Challenge toChallenge(ChallengeAddRequest challengeAddRequest);

}
