package com.walkers.sportslight.userChallenge.command.application.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserChallengeAddResponseDTO {
    private long userChallengeId;
    private int prevRecord;
    private int currentRecord;
    private int rank;
}
