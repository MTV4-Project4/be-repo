package com.walkers.sportslight.userChallenge.command.application.service;

import com.walkers.sportslight.challenge.command.domain.model.Challenge;
import com.walkers.sportslight.challenge.command.domain.repository.ChallengeRepository;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeDeleteDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeMapper;
import com.walkers.sportslight.userChallenge.command.application.dto.UserChallengeRegistServiceDTO;
import com.walkers.sportslight.userChallenge.command.application.dto.response.UserChallengeAddResponseDTO;
import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserBestRecord;
import com.walkers.sportslight.userChallenge.command.domain.aggregate.UserChallenge;
import com.walkers.sportslight.userChallenge.command.domain.service.ChallengeRecordService;
import com.walkers.sportslight.userChallenge.command.repository.UserChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserChallengeService {

    private final ChallengeRepository challengeRepository;
    private final UserChallengeRepository userChallengeRepository;
    private final UserChallengeMapper userChallengeMapper;
    private final ChallengeRecordService challengeRecordService;
    private final BestRecordService bestRecordService;

    @Transactional
    public UserChallengeAddResponseDTO registUserChallenge(UserChallengeRegistServiceDTO userChallengeInfo) {
        log.info("만들어진 유저 challenge 서비스 정보 {}",userChallengeInfo);
        Challenge challenge = challengeRepository.findById(userChallengeInfo.getChallengeId())
                .orElseThrow(()->new NoSuchElementException("존재하지 않는 챌린지입니다."));

        if (challenge.getExpiresAt().isBefore(userChallengeInfo.getParticipateTime())){
            log.warn("challenge is expired. challengeId:{}, expiresAt:{}",challenge.getChallengeId(),challenge.getExpiresAt());
            throw new IllegalArgumentException("만료되었습니다.");
        }

        UserChallenge userChallenge = userChallengeMapper.toUserChallenge(userChallengeInfo);

        UserBestRecord prevBestRecord = bestRecordService.findBestRecordOrNullByUserNoAndChallengeId(
                userChallengeInfo.getUserNo(), userChallengeInfo.getChallengeId());

        if(challengeRecordService.isNewRecord(
                userChallenge.getUserNo(), userChallenge.getChallengeId(), userChallenge.getRecord())){
                bestRecordService.updateBestRecord(userChallenge.getUserNo(), userChallenge.getChallengeId()
                , userChallenge.getRecord(), userChallenge.getParticipateTime());
        }

        int currentScoreRank = challengeRecordService.getCurrentScoreRank(
                userChallenge.getUserNo(), userChallenge.getChallengeId(),
                userChallenge.getRecord()
        );

        return new UserChallengeAddResponseDTO(userChallengeRepository.save(userChallenge).getUserChallengeId(),
                prevBestRecord.getRecord(), userChallenge.getRecord(),
                currentScoreRank);

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
