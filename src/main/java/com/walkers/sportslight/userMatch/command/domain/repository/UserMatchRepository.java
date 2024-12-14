package com.walkers.sportslight.userMatch.command.domain.repository;

import com.walkers.sportslight.userMatch.command.domain.aggregate.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMatchRepository extends JpaRepository<UserMatch, Long> {
}
