package com.walkers.sportslight.challengeFavorites.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserFavoriteResponseDTO {
    private long userNo;
    private List<ChallengeFavoriteDTO> favorites;
}
