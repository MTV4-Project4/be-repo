package com.walkers.sportslight.user.command.application.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthResponseDTO {
    private long userNo;
    private String nickname;
}
