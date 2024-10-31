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

    public UserRegistServiceDTO(UserRegistRequestDTO userRegistRequestDTO, Authority authority, UserStatus status) {
        this.userId = userRegistRequestDTO.getUserId();
        this.password = userRegistRequestDTO.getPassword();
        this.nickname = userRegistRequestDTO.getNickname();
        this.age = userRegistRequestDTO.getAge();
        this.phoneNumber = userRegistRequestDTO.getPhoneNumber();
        this.address = userRegistRequestDTO.getAddress();
        this.authority = authority;
        this.status = status;
        this.experience=0;
    }
}
