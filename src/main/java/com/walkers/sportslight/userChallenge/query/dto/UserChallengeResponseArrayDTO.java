package com.walkers.sportslight.userChallenge.query.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserChallengeResponseArrayDTO {
    private List<UserChallengeListDTO> rankingDataArray;
}
