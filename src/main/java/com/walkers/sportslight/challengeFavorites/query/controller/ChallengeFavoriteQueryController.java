package com.walkers.sportslight.challengeFavorites.query.controller;

import com.walkers.sportslight.challengeFavorites.query.dto.ChallengeFavoriteDTO;
import com.walkers.sportslight.challengeFavorites.query.dto.UserFavoriteResponseDTO;
import com.walkers.sportslight.challengeFavorites.query.service.ChallengeFavoriteQueryService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@Tag(name="챌린지 즐겨찾기 조회 API", description = "유저가 등록한 챌린지 즐겨찾기 정보를 조회하는 API")
public class ChallengeFavoriteQueryController {

    private ChallengeFavoriteQueryService challengeFavoriteQueryService;

    public ChallengeFavoriteQueryController(ChallengeFavoriteQueryService challengeFavoriteQueryService) {
        this.challengeFavoriteQueryService = challengeFavoriteQueryService;
    }


    @Operation(summary = "유저 챌린지 즐겨찾기 조회")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "즐겨찾기 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재 하지 않는 유저")
    })
    @GetMapping("user/{userNo}/challenge-favorite")
    public UserFavoriteResponseDTO findUserChallengeFavorite(@PathVariable long userNo){

        log.info("try to get user-favorite list, userNo:{}", userNo);
        return new UserFavoriteResponseDTO(
                userNo,
                challengeFavoriteQueryService.findUserFavorite(userNo)
        );
    }
}
