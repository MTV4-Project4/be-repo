package com.walkers.sportslight.userMotionChallenge.command.domain.service;

public interface SimilarityCheckService {

    public double getSimilarity(long motionChallengeId, String userMotionFile);
}
