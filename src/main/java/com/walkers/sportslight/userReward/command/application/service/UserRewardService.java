package com.walkers.sportslight.userReward.command.application.service;

import com.walkers.sportslight.userReward.command.application.dto.UserRewardDTO;
import com.walkers.sportslight.userReward.command.application.dto.UserRewardMapper;
import com.walkers.sportslight.userReward.command.domain.aggregate.UserReward;
import com.walkers.sportslight.userReward.command.domain.repository.UserRewardRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRewardService {

    private UserRewardRepository userRewardRepository;
    private UserRewardMapper userRewardMapper;

    public UserRewardService(UserRewardRepository userRewardRepository, UserRewardMapper userRewardMapper) {
        this.userRewardRepository = userRewardRepository;
        this.userRewardMapper = userRewardMapper;
    }

    public long addUserRewardInfo(UserRewardDTO userRewardInfo){
        userRewardInfo.getChallengeRewardId();
        UserReward userReward = userRewardMapper.toUserReward(userRewardInfo);

        return userRewardRepository.save(userReward).getUserRewardId();

    }
}
