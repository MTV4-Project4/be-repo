package com.walkers.sportslight.userMatch.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UserMatchServiceRequest {
    private final long challengeId;
    private final long user1Id;
    private final long user2Id;

    private final int user1Score;
    private final int user2Score;

    private final LocalDateTime matchTime;

    public UserMatchServiceRequest(UserMatchRequest userMatchRequest, long challengeId, LocalDateTime matchTime) {
        this.challengeId = challengeId;
        this.user1Id = userMatchRequest.getUser1Id();
        this.user2Id = userMatchRequest.getUser2Id();
        this.user1Score = userMatchRequest.getUser1Score();
        this.user2Score = userMatchRequest.getUser2Score();
        this.matchTime = matchTime;
    }
}
