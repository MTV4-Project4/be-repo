package com.walkers.sportslight.userChallenge.command.application.service;

import com.walkers.sportslight.challenge.domain.model.Challenge;
import com.walkers.sportslight.challenge.domain.repository.ChallengeRepository;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeDeleteDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeMapper;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeRegistServiceDTO;
import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import com.walkers.sportslight.userChallenge.command.repository.UserChallengeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class UserChallengeService {

    private ChallengeRepository challengeRepository;
    private UserChallengeRepository userChallengeRepository;
    private UserChallengeMapper userChallengeMapper;

    public UserChallengeService(ChallengeRepository challengeRepository, UserChallengeRepository userChallengeRepository, UserChallengeMapper userChallengeMapper) {
        this.challengeRepository = challengeRepository;
        this.userChallengeRepository = userChallengeRepository;
        this.userChallengeMapper = userChallengeMapper;
    }

    @Transactional
    public void registUserChallenge(UserChallengeRegistServiceDTO userChallengeInfo) {
        Challenge challenge = challengeRepository.findById(userChallengeInfo.getChallengeId())
                .orElseThrow(()->new NoSuchElementException("존재하지 않는 챌린지입니다."));

        if (challenge.getExpiresAt().isBefore(userChallengeInfo.getParticipateTime())){
            throw new IllegalArgumentException("만료되었습니다.");
        }

        UserChallenge userChallenge = userChallengeRepository.findByUserNoAndChallengeId(
                userChallengeInfo.getUserNo(), userChallengeInfo.getChallengeId()
        );

        if(userChallenge !=null){
            userChallenge.update(userChallenge.getRecord(), userChallengeInfo.getParticipateTime());
        } else{
            userChallenge = userChallengeMapper.toUserChallenge(userChallengeInfo);
            userChallengeRepository.save(userChallenge);
        }

    }

    @Transactional
    public void updateUserChallenge(long userChallengeId, int record, LocalDateTime registrationDate) {
        UserChallenge challenge = userChallengeRepository.findById(userChallengeId)
                .orElseThrow(()->new NoSuchElementException("존재하지 않는 챌린지입니다."));

        challenge.update(record, registrationDate);
    }

    @Transactional
    public void deleteUserChallenge(UserChallengeDeleteDTO userChallengeDeleteDTO) {

        UserChallenge challenge = userChallengeRepository.findById(userChallengeDeleteDTO.getUserChallengeId())
                .orElseThrow(()->new NoSuchElementException("존재하지 않는 챌린지입니다"));


        if (challenge.getUserNo()!=userChallengeDeleteDTO.getUserNo()){
            throw new SecurityException("접근이 불가능합니다.");
        }

        userChallengeRepository.deleteById(userChallengeDeleteDTO.getUserChallengeId());
    }
}
