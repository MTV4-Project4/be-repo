package com.walkers.sportslight.userMotionChallenge.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserMotionChallengeResult {
    private double similarity;
    private String result;
}
