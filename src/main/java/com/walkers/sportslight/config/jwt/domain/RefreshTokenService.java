package com.walkers.sportslight.config.jwt.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected Token"));
    }

//    public RefreshToken saveRefreshToken(String userId, String refreshToken) {
//        return refreshTokenRepository.save(new RefreshToken(userId, refreshToken));
//    }

}
