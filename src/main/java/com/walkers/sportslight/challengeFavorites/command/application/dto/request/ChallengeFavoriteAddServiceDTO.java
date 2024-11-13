package com.walkers.sportslight.challengeFavorites.command.application.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ChallengeFavoriteAddServiceDTO {
    private final long userNo;
    private final long challengeId;
    private final LocalDateTime addedDate;
}
