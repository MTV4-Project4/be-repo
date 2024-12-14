package com.walkers.sportslight.user.command.application.dto;

import com.walkers.sportslight.user.command.domain.model.Birthday;
import com.walkers.sportslight.user.command.domain.model.Authority;
import com.walkers.sportslight.user.command.domain.model.LoginType;
import com.walkers.sportslight.user.command.domain.model.UserStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
public class UserRegistServiceDTO {
    private final String userId;
    private final String password;
    private final String nickname;
    private final String phoneNumber;
    private final String address;
    private final Authority authority;
    private final UserStatus status;
    private final Birthday birthday;
    private final int money;
    private final double height;
    private final double weight;
    private final LoginType loginType;

    public UserRegistServiceDTO(UserAuthRequestDTO.signUpDTO userRegistRequestDTO,
                                Authority authority, UserStatus status, Birthday birthday, LoginType loginType) {
        this.userId = userRegistRequestDTO.userId();
        this.password = userRegistRequestDTO.password();
        this.nickname = userRegistRequestDTO.nickname();
        this.phoneNumber = userRegistRequestDTO.phoneNumber();
        this.address = userRegistRequestDTO.address();
        this.authority = authority;
        this.status = status;
        this.birthday = birthday;
        this.money=0;
        this.height=170.0; //임시 값
        this.weight=70.0;
        this.loginType=loginType;
//        this.height = userRegistRequestDTO.height();
//        this.weight = userRegistRequestDTO.weight();
    }



    @Override
    public String toString() {
        return "UserRegistServiceInfo{" +
                "userId='" + userId + '\'' +
                ", password='" + "[PROTECTED]" + '\'' +
                ", nickname='" + nickname + '\'' +
                ", authority=" + authority +
                ", status=" + status +
                '}';
    }
}
