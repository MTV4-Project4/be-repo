package com.walkers.sportslight.motionChallenge.command.application.dto;

import com.walkers.sportslight.motionChallenge.command.domain.aggregate.MotionChallenge;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MotionChallengeMapper {
    MotionChallengeMapper INSTANCE = Mappers.getMapper(MotionChallengeMapper.class);

    //@Mapping(target = "motionFileUrl", ignore = true)
    MotionChallenge toChallenge(MotionChallengeAddRequest motionInfo);
}
