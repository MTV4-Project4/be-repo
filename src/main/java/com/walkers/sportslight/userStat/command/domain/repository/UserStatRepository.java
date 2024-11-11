package com.walkers.sportslight.userStat.command.domain.repository;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserStatRepository extends JpaRepository<UserStat, Long> {

    void deleteByUserNo(long userNo);

    Optional<UserStat> findByUserNoAndAndStatType(long userNo, StatType statType);
}
