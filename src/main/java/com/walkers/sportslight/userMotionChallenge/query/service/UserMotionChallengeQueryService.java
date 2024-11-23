package com.walkers.sportslight.userMotionChallenge.query.service;

import com.walkers.sportslight.userMotionChallenge.command.domain.service.SimilarityCheckService;
import com.walkers.sportslight.userMotionChallenge.query.dto.UserMotionChallengeResult;
import com.walkers.sportslight.userMotionChallenge.query.repository.UserMotionChallengeQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class UserMotionChallengeQueryService {

    private UserMotionChallengeQueryRepository userMotionChallengeQueryRepository;
    private SimilarityCheckService similarityCheckService;

    public UserMotionChallengeQueryService(UserMotionChallengeQueryRepository userMotionChallengeQueryRepository, SimilarityCheckService similarityCheckService) {
        this.userMotionChallengeQueryRepository = userMotionChallengeQueryRepository;
        this.similarityCheckService = similarityCheckService;
    }

    public UserMotionChallengeResult findChallengeResultById(long userMotionChallengeId){
        double similarity = userMotionChallengeQueryRepository.findSimilarityById(userMotionChallengeId);
        return new UserMotionChallengeResult(
                similarity, similarityCheckService.getResult(similarity)
        );

    }


}
