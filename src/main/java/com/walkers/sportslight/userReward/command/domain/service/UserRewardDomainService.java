package com.walkers.sportslight.userReward.command.domain.service;

import com.walkers.sportslight.userReward.command.domain.aggregate.UserReward;
import com.walkers.sportslight.userReward.command.domain.repository.UserRewardRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRewardDomainService {

    private UserRewardRepository userRewardRepository;

    public UserRewardDomainService(UserRewardRepository userRewardRepository) {
        this.userRewardRepository = userRewardRepository;
    }

    public void registerAddress(UserReward userReward, String address) {
        userReward.setAddress(address);
        userRewardRepository.save(userReward);
    }

    public void sendReward(UserReward userReward) {
        userReward.markAsSent(); // 발송 상태로 변경
        userRewardRepository.save(userReward);
    }
}
