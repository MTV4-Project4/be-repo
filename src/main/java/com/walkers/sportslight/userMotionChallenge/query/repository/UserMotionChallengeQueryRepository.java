package com.walkers.sportslight.userMotionChallenge.query.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMotionChallengeQueryRepository {
    double findSimilarityById(long userMotionChallengeId);
}
