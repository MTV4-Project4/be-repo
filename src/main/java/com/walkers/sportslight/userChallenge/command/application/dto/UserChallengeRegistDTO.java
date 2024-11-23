package com.walkers.sportslight.userChallenge.command.application.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@ToString
public class UserChallengeRegistDTO {
    @PositiveOrZero(message = "기록은 음이 아닌 수로 입력해 주세요.")
    private int record;
}
