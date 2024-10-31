package com.walkers.sportslight.user.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRegistRequestDTO {
    private final String userId;
    private final String password;
    private final String nickname;
    private final int age;
    private final String phoneNumber;
    private final String address;

}
