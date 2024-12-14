package com.walkers.sportslight.userMatch.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserMatchRequest {
    private long user1Id;
    private long user2Id;

    private int user1Score;
    private int user2Score;
}
