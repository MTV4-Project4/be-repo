package com.walkers.sportslight.config.jwt;

import com.walkers.sportslight.config.jwt.domain.RefreshToken;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenService;
import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtTokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserRepository userRepository;

    public String createNewAccessToken(String refreshToken){
        //토큰 유효성 검사에 실패하면 예외
        if(!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        RefreshToken foundToken = refreshTokenService.findByRefreshToken(refreshToken);
        User user =userRepository.findByUserId(foundToken.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user"));

        return tokenProvider.generateToken(user.getUserId(), user.getNickname(), Duration.ofHours(2));
    }

    public void setAccessTokenHeader(HttpServletResponse response, String accessToken) {
        response.setHeader("Authorization", accessToken);
    }

    public void setRefreshTokenHeader(HttpServletResponse response, String refreshToken) {
        response.setHeader("Authorization-refresh", refreshToken);
    }


}
