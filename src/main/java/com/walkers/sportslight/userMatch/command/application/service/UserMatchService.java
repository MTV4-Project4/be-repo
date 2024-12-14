package com.walkers.sportslight.userMatch.command.application.service;

import com.walkers.sportslight.userMatch.command.application.dto.UserMatchMapper;
import com.walkers.sportslight.userMatch.command.application.dto.UserMatchServiceRequest;
import com.walkers.sportslight.userMatch.command.domain.aggregate.UserMatch;
import com.walkers.sportslight.userMatch.command.domain.repository.UserMatchRepository;
import org.springframework.stereotype.Service;

@Service
public class UserMatchService {

    private UserMatchRepository userMatchRepository;
    private UserMatchMapper userMatchMapper;

    public UserMatchService(UserMatchRepository userMatchRepository, UserMatchMapper userMatchMapper) {
        this.userMatchRepository = userMatchRepository;
        this.userMatchMapper = userMatchMapper;
    }

    public long addUserMatch(UserMatchServiceRequest userMatchServiceRequest) {
        UserMatch userMatch = userMatchMapper.toUserMatch(userMatchServiceRequest);
        return userMatchRepository.save(userMatch).getUserMatchId();
    }

    public void deleteUserMatchById(long matchId) {
        userMatchRepository.deleteById(matchId);
    }
}
