package com.walkers.sportslight.user.command.application.dto;

import com.walkers.sportslight.user.command.domain.model.Authority;
import com.walkers.sportslight.user.command.domain.model.UserStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRegistServiceDTO {
    private final String userId;
    private final String password;
    private final String nickname;
    private final int age;
    private final String phoneNumber;
    private final String address;
    private final Authority authority;
    private final UserStatus status;
    private final int experience;

    public UserRegistServiceDTO(UserAuthRequestDTO.signUpDTO userRegistRequestDTO, Authority authority, UserStatus status) {
        this.userId = userRegistRequestDTO.userId();
        this.password = userRegistRequestDTO.password();
        this.nickname = userRegistRequestDTO.nickname();
        this.age = userRegistRequestDTO.age();
        this.phoneNumber = userRegistRequestDTO.phoneNumber();
        this.address = userRegistRequestDTO.address();
        this.authority = authority;
        this.status = status;
        this.experience=0;
    }
}
