package com.walkers.sportslight.config.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class AddAccessTokenResponse {
    private String accessToken;
}
