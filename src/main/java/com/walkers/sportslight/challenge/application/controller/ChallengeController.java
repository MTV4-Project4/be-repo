package com.walkers.sportslight.challenge.application.controller;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.challenge.application.dto.ChallengeAddRequest;
import com.walkers.sportslight.challenge.application.service.ChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Tag(name="챌린지 API", description = "챌린지를 관리하는 API")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping("challenge")
    @Operation(summary = "챌린지 등록")
    public long addChallenge(@RequestBody ChallengeAddRequest challengeRegist) {
        long challengeId = challengeService.addChallenge(challengeRegist);
        return challengeId;
    }

    @PutMapping("challenge/{challengeId}")
    @Operation(summary = "챌린지 수정")
    public void updateChallenge(@PathVariable long challengeId, @RequestBody ChallengeAddRequest challengeUpdate) {
        // challengeUpdate
        challengeService.updateChallenge(challengeId, challengeUpdate);
    }

    @DeleteMapping("challenge/{challengeId}")
    @Operation(summary = "챌린지 삭제")
    public void deleteChallenge(@PathVariable long challengeId) {
        // challenge delete
        challengeService.deleteChallenge(challengeId);
    }


}
