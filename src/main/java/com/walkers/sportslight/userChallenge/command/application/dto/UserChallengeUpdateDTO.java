package com.walkers.sportslight.userChallenge.command.application.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserChallengeUpdateDTO {
    @PositiveOrZero(message = "기록은 음이 아닌 수로 입력해 주세요.")
    private int record;

    public UserChallengeUpdateDTO(int record) {
        this.record = record;
    }
}
