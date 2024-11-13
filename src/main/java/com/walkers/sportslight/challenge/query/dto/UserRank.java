package com.walkers.sportslight.challenge.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRank {
    private int ranking;
    private int record;
    private long userNo;
    private String nickname;

}
