package com.walkers.sportslight.userMatch.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MatchProfileDTO {
    private long userNo;
    private String userName;
    private int numMatch;
    private int numWin;
    private double winRate;
}
