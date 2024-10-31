package com.walkers.sportslight.user.query.service;

import com.walkers.sportslight.user.query.repository.UserQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {
    private UserQueryRepository userQueryRepository;

    public UserQueryService(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }
}
