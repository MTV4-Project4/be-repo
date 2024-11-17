package com.walkers.sportslight.challengeFavorites.command.application.dto.request;

import lombok.*;


@RequiredArgsConstructor
@Getter
public class ChallengeFavoriteDeleteDTO {
    private final long favoriteId;
}
