package com.walkers.sportslight.userChallenge.command.application.service;

import com.walkers.sportslight.challenge.domain.model.Challenge;
import com.walkers.sportslight.challenge.domain.repository.ChallengeRepository;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeDeleteDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeMapper;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeRegistServiceDTO;
import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import com.walkers.sportslight.userChallenge.command.repository.UserChallengeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
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
    public long registUserChallenge(UserChallengeRegistServiceDTO userChallengeInfo) {
        log.info("만들어진 유저 challenge 서비스 정보 {}",userChallengeInfo);
        Challenge challenge = challengeRepository.findById(userChallengeInfo.getChallengeId())
                .orElseThrow(()->new NoSuchElementException("존재하지 않는 챌린지입니다."));

        if (challenge.getExpiresAt().isBefore(userChallengeInfo.getParticipateTime())){
            throw new IllegalArgumentException("만료되었습니다.");
        }

        Optional<UserChallenge> userChallenge = userChallengeRepository.findByUserNoAndChallengeId(
                userChallengeInfo.getUserNo(), userChallengeInfo.getChallengeId()
        );

        UserChallenge newUserChallenge=null;

        if(userChallenge.isPresent()){

            userChallenge.get().update(userChallengeInfo.getRecord(), userChallengeInfo.getParticipateTime());
            newUserChallenge = userChallenge.get();
        } else{
            newUserChallenge = userChallengeMapper.toUserChallenge(userChallengeInfo);
            log.info("새로 추가된 서비스 정보:{}", newUserChallenge);
            newUserChallenge = userChallengeRepository.save(newUserChallenge);
        }

        int currentRecordRank = userChallengeRepository.countByChallengeIdAndRecordGreaterThanEqual(
                userChallengeInfo.getChallengeId(),
                userChallengeInfo.getRecord()
        );

        return newUserChallenge.getUserChallengeId();

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
