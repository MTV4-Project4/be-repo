package com.walkers.sportslight.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final static String HEADER_AUTHORIZATION = "Authorization";
    private final static String TOKEN_PREFIX = "Bearer ";
    private final JwtTokenProvider jwtTokenProvider;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Request Header에서 Jwt Token 추출
        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);

        String requestURI = request.getRequestURI();


        // 접두사 제거
        String token = getAccessToken(authorizationHeader);

        if(shouldNotFilter(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        if ( requestURI.equals("/api/login") || requestURI.startsWith("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        //토큰 유효성 검사
        if (jwtTokenProvider.validToken(token)) {
            if(!requestURI.equals("/api/logout")){
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.info("{} is login.", authentication.getName());
                filterChain.doFilter(request, response);
                return;
            }
        }

        if(requestURI.startsWith("/api")) {
//            log.info("넘어가지는지 테스트");
            filterChain.doFilter(request, response);
            return;
        }

        throw new IllegalStateException("invalid access");
    }

    private String getAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.startsWith("/actuator")
                ||path.equals("/favicon.ico"); // Prometheus 관련 경로는 필터링 제외

    }
}
