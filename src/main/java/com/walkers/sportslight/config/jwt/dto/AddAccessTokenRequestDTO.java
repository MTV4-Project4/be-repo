package com.walkers.sportslight.config.jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAccessTokenRequestDTO {
    private String refreshToken;
}
