package com.walkers.sportslight.httpConnection;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.MotionImageDataRequestDTO;
import com.walkers.sportslight.userMotionChallenge.command.domain.infrastructure.VO.SimilarityResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Map;

@HttpExchange("https://kauth.kakao.com/")
public interface KakaoHttpClient {

    @PostExchange(value = "/oauth/token", contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    KakaoTokenResponse requestAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("code") String code
    );
}
