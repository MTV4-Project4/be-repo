package com.walkers.sportslight.challengeFavorites.command.domain.repository;

import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeFavoriteRepository extends JpaRepository<ChallengeFavorite, Long> {
    Optional<ChallengeFavorite> findChallengeFavoriteByUserNoAndChallengeId(long userNo, long challengeId);
    void deleteChallengeFavoriteByUserNoAndChallengeId(long userNo, long challengeId);

}
