package com.walkers.sportslight.config.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class CustomEmailAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String DEFAULT_LOGIN_REQUEST_URL = "/api/login";
    //private static final String HTTP_METHOD = "POST"; // 로그인 HTTP 메소드는 POST
    private static final String CONTENT_TYPE = "application/json"; // JSON 타입의 데이터로 오는 로그인 요청만 처리

    private final ObjectMapper objectMapper;
    public CustomEmailAuthenticationFilter(ObjectMapper objectMapper) {
        super(new AntPathRequestMatcher(DEFAULT_LOGIN_REQUEST_URL, "POST"));
        this.objectMapper=objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (request.getContentType() == null || !request.getContentType().equals(CONTENT_TYPE)) {
            throw new AuthenticationServiceException("Authentication Content-Type not supported: " + request.getContentType());
        }

        String messageBody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);

        Map<String, String> usernamePasswordMap = objectMapper.readValue(messageBody, Map.class);

        String userId = usernamePasswordMap.get("userId");
        String password = usernamePasswordMap.get("password");

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userId, password);//principal 과 credentials 전달

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
