package com.walkers.sportslight.config.oauth2;

import com.walkers.sportslight.config.jwt.JwtTokenProvider;
import com.walkers.sportslight.config.jwt.TokenService;
import com.walkers.sportslight.config.jwt.domain.RefreshToken;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenRepository;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenService;
import com.walkers.sportslight.user.command.domain.model.Authority;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final TokenService tokenService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    //private final RefreshTokenService refreshTokenService;

    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("success OAuth2 login!");

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        loginSuccess(response, oAuth2User);
    }

    @Transactional
    public void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException{

        User user = userRepository.findByUserId(oAuth2User.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Optional<RefreshToken> tokenOptional = refreshTokenRepository.findByUserId(user.getUserId());

        RefreshToken currentRefreshToken=null;
        currentRefreshToken = tokenOptional.orElseGet(() -> refreshTokenRepository.save(new RefreshToken(user.getUserId(),
                jwtTokenProvider.generateToken(user.getUserId(), user.getNickname(), Duration.ofDays(14)))));
        //String refreshToken = jwtTokenProvider.generateToken(user.getUserId(), user.getNickname());

        String refreshToken = currentRefreshToken.getRefreshToken();

        String accessToken = tokenService.createNewAccessToken(refreshToken);

        response.addHeader("accessToken", "Bearer " +accessToken);
        response.addHeader("refreshToken", "Bearer " + refreshToken);


        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");


        //RefreshToken newRefreshToken = refreshTokenService.findByRefreshToken(refreshToken);
        //newRefreshToken.update(refreshToken);
        response.setStatus(HttpServletResponse.SC_OK);

        String responseBody = String.format(
                "{\"userNo\": " +user.getUserNo() + "}"
        );

        response.getWriter().write(responseBody);
        response.getWriter().flush();
    }
}
