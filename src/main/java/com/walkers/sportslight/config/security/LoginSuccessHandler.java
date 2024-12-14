package com.walkers.sportslight.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walkers.sportslight.config.jwt.JwtTokenProvider;
import com.walkers.sportslight.config.jwt.TokenService;
import com.walkers.sportslight.config.jwt.domain.RefreshToken;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenRepository;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenService;
import com.walkers.sportslight.user.command.application.dto.UserAuthResponseDTO;
import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenService tokenService;
    private final JwtTokenProvider jwtTokenProvider;

    // access Token 시간 : 2시간
    private static final Duration ACCESS_TOKEN_LIFE_TIME = Duration.ofHours(2);
    private static final Duration REFRESH_TOKEN_LIFE_TIME = Duration.ofDays(14);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        String userId = extractUsername(authentication);
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));
        String refreshToken = jwtTokenProvider.generateToken(
                userId, user.getNickname(), REFRESH_TOKEN_LIFE_TIME
        );
        String accessToken = jwtTokenProvider.generateToken(
                userId, user.getNickname(), ACCESS_TOKEN_LIFE_TIME
        );

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        tokenService.setAccessTokenHeader(response,
                accessToken);
        tokenService.setRefreshTokenHeader(response, refreshToken);

        saveRefreshToken(userId, refreshToken);

        // 임시로 body에 유저번호 반환
//        String responseBody = String.format(
//                "{\"userNo\": " +user.getUserNo() + "}"
//        );

        ObjectMapper objectMapper = new ObjectMapper();
        UserAuthResponseDTO userAuthResponse = new UserAuthResponseDTO(user.getUserNo(), user.getNickname());
        String responseBody = objectMapper.writeValueAsString(userAuthResponse);

        response.getWriter().write(responseBody);
        response.getWriter().flush();

        log.info("success to login, userNo: {}, userId:{}", user.getUserNo(), userId);
    }

    private String extractUsername(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }

    private void saveRefreshToken(String userId, String newRefreshToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId)
                .map(entity->entity.update(newRefreshToken))
                .orElse(new RefreshToken(userId, newRefreshToken));

        refreshTokenRepository.save(refreshToken);
    }
}
