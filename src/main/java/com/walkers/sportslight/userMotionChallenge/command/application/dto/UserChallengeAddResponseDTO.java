package com.walkers.sportslight.userMotionChallenge.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserChallengeAddResponseDTO {
    private long userMotionChallengeId;
    private double similarity;
    private String result;

}
