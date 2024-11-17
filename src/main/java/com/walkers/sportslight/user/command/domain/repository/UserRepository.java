package com.walkers.sportslight.user.command.domain.repository;

import com.walkers.sportslight.user.command.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
