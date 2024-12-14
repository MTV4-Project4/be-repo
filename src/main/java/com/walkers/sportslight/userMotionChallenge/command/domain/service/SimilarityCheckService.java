package com.walkers.sportslight.userMotionChallenge.command.domain.service;

import com.walkers.sportslight.userMotionChallenge.command.infrastructure.VO.SimilarityResult;

public interface SimilarityCheckService {

    SimilarityResult getSimilarity(long motionChallengeId, String userMotionFile);

    String getResult(double similarity);
}
