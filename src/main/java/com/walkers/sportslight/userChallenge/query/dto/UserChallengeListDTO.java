package com.walkers.sportslight.userChallenge.query.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UserChallengeListDTO {
    @JsonIgnore
    private final long userChallengeId;
    @JsonIgnore
    private final long challengeId;

    @JsonProperty("missionName")
    private final String challengeName;

    @JsonProperty("score")
    private final int record;
    @JsonProperty("rank")
    private final int ranking;

    @JsonProperty("challengeTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime expireAt;

//    public UserChallengeResponseDTO(long userChallengeId, long challengeId, String challengeName, int record,
//                                    int ranking, LocalDateTime expireAt) {
//        this.userChallengeId = userChallengeId;
//        this.challengeId = challengeId;
//        this.challengeName = challengeName;
//        this.record = record;
//        this.ranking = ranking;
//        this.expireAt = expireAt;
//    }
}
