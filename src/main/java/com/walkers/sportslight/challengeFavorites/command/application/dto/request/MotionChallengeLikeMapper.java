package com.walkers.sportslight.challengeFavorites.command.application.dto.request;


import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.MotionChallengeLike;
import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MotionChallengeLikeMapper {
    MotionChallengeLikeMapper INSTANCE = Mappers.getMapper(MotionChallengeLikeMapper.class);

    @Mapping(source = "challengeId", target = "motionChallengeId")
    MotionChallengeLike toLike(ChallengeFavoriteAddServiceDTO userFavoriteInfo);
}
