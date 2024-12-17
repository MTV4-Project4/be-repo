package com.walkers.sportslight.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walkers.sportslight.common.logging.MDCFilter;
import com.walkers.sportslight.config.jwt.JwtTokenProvider;
import com.walkers.sportslight.config.jwt.TokenAuthenticationFilter;
import com.walkers.sportslight.config.jwt.TokenService;
import com.walkers.sportslight.config.jwt.domain.RefreshTokenRepository;
import com.walkers.sportslight.config.oauth2.CustomOAuth2UserService;
import com.walkers.sportslight.config.oauth2.OAuth2LoginFailureHandler;
import com.walkers.sportslight.config.oauth2.OAuth2LoginSuccessHandler;
import com.walkers.sportslight.config.security.LoginSuccessHandler;
import com.walkers.sportslight.config.security.filter.CustomEmailAuthenticationFilter;
import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.context.SecurityContextHolderFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenService tokenService;
    private final ObjectMapper objectMapper;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CustomUserDetailService loginService;
    private final JwtTokenProvider jwtTokenProvider;
    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
    public AuthenticationManager authenticationManager(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(loginService);
        return new ProviderManager(authProvider);

    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler(){
        return new LoginSuccessHandler(userRepository,
                refreshTokenRepository, tokenService, jwtTokenProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, UserService userService) throws Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(
                        session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(
                        authorizeRequest->
                                authorizeRequest
                                        .requestMatchers("api/login-data").authenticated()
                                        .anyRequest().permitAll()
                )
                .oauth2Login(
                        oauth2-> oauth2
                                .successHandler(oAuth2LoginSuccessHandler)
                                .failureHandler(oAuth2LoginFailureHandler)
                                .userInfoEndpoint(userinfo->userinfo.userService(customOAuth2UserService))
                )
                .addFilterBefore(mdcFilter(), SecurityContextHolderFilter.class)
                .addFilterBefore(customEmailAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(tokenAuthenticationFilter(), CustomEmailAuthenticationFilter.class)
;

        return httpSecurity.build();
    }
//
//    @Bean
//    public LoginSuccessHandler loginSuccessHandler() {
//    }

    @Bean MDCFilter mdcFilter(){
        return new MDCFilter();
    }

    @Bean
    public CustomEmailAuthenticationFilter customEmailAuthenticationFilter(){
        CustomEmailAuthenticationFilter customEmailAuthenticationFilter
                = new CustomEmailAuthenticationFilter(objectMapper);

        customEmailAuthenticationFilter.setAuthenticationManager(authenticationManager());
        customEmailAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());

        return customEmailAuthenticationFilter;
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter(){
        return new TokenAuthenticationFilter(jwtTokenProvider);
    }

}