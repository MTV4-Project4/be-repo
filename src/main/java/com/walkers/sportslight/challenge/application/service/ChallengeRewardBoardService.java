package com.walkers.sportslight.challenge.application.service;

import com.walkers.sportslight.challenge.application.dto.ChallengeRewardMapper;
import com.walkers.sportslight.challenge.application.dto.RewardModifyServiceDTO;
import com.walkers.sportslight.challenge.domain.model.ChallengeReward;
import com.walkers.sportslight.challenge.domain.repository.ChallengeRewardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
// 트랜잭션 적용을 위해 별도 서비스로 분리, 따라서 package private 접근제어자 사용
class ChallengeRewardBoardService {

    private final ChallengeRewardMapper challengeRewardMapper;
    private final ChallengeRewardRepository challengeRewardRepository;

    @Transactional
    long addRewardBoard(RewardModifyServiceDTO rewardInfo, String imageUrl){
        ChallengeReward challengeReward = challengeRewardMapper.toChallengeReward(rewardInfo);
        challengeReward.setRewardImagePath(imageUrl);
        return challengeRewardRepository.save(challengeReward).getRewardId();
    }

    @Transactional
    void changeRewardChecked(long challengeRewardId, String isChecked){
        ChallengeReward challengeReward = challengeRewardRepository.findById(challengeRewardId)
                .orElseThrow(()->new NoSuchElementException("해당 보상정보를 찾을 수 없습니다."));

        challengeReward.setIsChecked("Y");
    }
}
