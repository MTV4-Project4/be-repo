package com.walkers.sportslight.user.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class AccountInfoResponseDTO {
    private long userNo;
    private String nickname;
    private int age;
    private String phoneNumber;
    private String address;
   // private final String
}
