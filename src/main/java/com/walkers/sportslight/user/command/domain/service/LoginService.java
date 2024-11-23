package com.walkers.sportslight.user.command.domain.service;

import com.walkers.sportslight.user.command.domain.model.User;

public interface LoginService {
    String encodePassword(String password);
    long login(String username, String password);
}
