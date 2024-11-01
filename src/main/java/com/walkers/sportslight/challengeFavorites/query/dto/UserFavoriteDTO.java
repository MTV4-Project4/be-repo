package com.walkers.sportslight.challengeFavorites.query.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserFavoriteDTO {
    private final String nickname;
    private final List<ChallengeFavoriteDTO> challengeFavorite;
}
