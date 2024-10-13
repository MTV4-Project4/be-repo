package com.walkers.sportslight.user.DTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRegistDTO {
    private final String userId;
    private final String nickname;
    private final String password;
    private final int experience;


}
