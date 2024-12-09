package com.walkers.sportslight.config.jwt.controller;

import com.walkers.sportslight.config.jwt.TokenService;
import com.walkers.sportslight.config.jwt.dto.AddAccessTokenRequestDTO;
import com.walkers.sportslight.config.jwt.dto.AddAccessTokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class TokenApiController {

    private TokenService tokenService;

    public TokenApiController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("token")
    @ResponseStatus(HttpStatus.CREATED)
    public AddAccessTokenResponse createNewAccessToken(
            @RequestBody AddAccessTokenRequestDTO request
            ) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());
        return new AddAccessTokenResponse(newAccessToken);
    }


}
