package com.walkers.sportslight.challengeFavorites.command.application.dto;

import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChallengeFavoriteMapper {
    ChallengeFavoriteMapper INSTANCE = Mappers.getMapper(ChallengeFavoriteMapper.class);

    ChallengeFavorite toFavorite(ChallengeFavoriteAddServiceDTO userFavoriteInfo);
}
