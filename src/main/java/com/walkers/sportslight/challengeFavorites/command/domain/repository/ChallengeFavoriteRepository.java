package com.walkers.sportslight.challengeFavorites.command.domain.repository;

import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeFavoriteRepository extends JpaRepository<ChallengeFavorite, Long> {

}
