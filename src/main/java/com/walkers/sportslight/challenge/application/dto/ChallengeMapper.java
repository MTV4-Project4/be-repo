package com.walkers.sportslight.challenge.application.dto;

import com.walkers.sportslight.challenge.domain.model.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface ChallengeMapper {
    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);
    Challenge toChallenge(ChallengeRequest challengeRequest);

}
