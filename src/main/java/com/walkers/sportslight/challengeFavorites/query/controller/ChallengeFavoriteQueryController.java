package com.walkers.sportslight.challengeFavorites.query.controller;

import com.walkers.sportslight.challengeFavorites.query.dto.ChallengeFavoriteDTO;
import com.walkers.sportslight.challengeFavorites.query.dto.UserFavoriteResponseDTO;
import com.walkers.sportslight.challengeFavorites.query.service.ChallengeFavoriteQueryService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@Tag(name="챌린지 즐겨찾기 조회 API", description = "유저가 등록한 챌린지 즐겨찾기 정보를 조회하는 API")
public class ChallengeFavoriteQueryController {

    private ChallengeFavoriteQueryService challengeFavoriteQueryService;

    public ChallengeFavoriteQueryController(ChallengeFavoriteQueryService challengeFavoriteQueryService) {
        this.challengeFavoriteQueryService = challengeFavoriteQueryService;
    }


    @Operation(summary = "유저 챌린지 즐겨찾기 조회")
    @GetMapping("user/{userNo}/challenge-favorite")
    public UserFavoriteResponseDTO findUserChallengeFavorite(@PathVariable long userNo){
        return new UserFavoriteResponseDTO(
                userNo,
                challengeFavoriteQueryService.findUserFavorite(userNo)
        );
    }
}
