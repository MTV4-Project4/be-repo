package com.walkers.sportslight.challengeFavorites.command.application.service;

import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.MotionChallengeLikeMapper;
import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.MotionChallengeLike;
import com.walkers.sportslight.challengeFavorites.command.domain.repository.MotionChallengeLikeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class MotionChallengeLikeService {

    private final MotionChallengeLikeMapper motionChallengeLikeMapper;
    private MotionChallengeLikeRepository motionChallengeLikeRepository;

    public MotionChallengeLikeService(MotionChallengeLikeRepository motionChallengeLikeRepository, MotionChallengeLikeMapper motionChallengeLikeMapper) {
        this.motionChallengeLikeRepository = motionChallengeLikeRepository;
        this.motionChallengeLikeMapper = motionChallengeLikeMapper;
    }

    @Transactional
    public long addLike(ChallengeFavoriteAddServiceDTO challengeFavoriteAddInfo) {

        log.info("to add creator challengeLike, userNo:{}, challengeId:{}",
                challengeFavoriteAddInfo.getUserNo(), challengeFavoriteAddInfo.getChallengeId());
        if(motionChallengeLikeRepository.existsByUserNoAndMotionChallengeId(
                        challengeFavoriteAddInfo.getUserNo(), challengeFavoriteAddInfo.getChallengeId())
        ) {
            throw new IllegalStateException("이미 좋아요가 된 상태입니다");
        }


        MotionChallengeLike motionChallengeLike = motionChallengeLikeMapper.toLike(challengeFavoriteAddInfo);
        return motionChallengeLikeRepository.save(motionChallengeLike).getLikeId();

    }

    @Transactional
    public void deleteByUserNoAndChallengeId(long userNo, long motionChallengeId) {

        if(!motionChallengeLikeRepository.existsByUserNoAndMotionChallengeId(userNo, motionChallengeId)){
            throw new NoSuchElementException("좋아요가 되지 않은 상태에서 취소할 수 없습니다.");
        }

        motionChallengeLikeRepository.deleteByUserNoAndMotionChallengeId(userNo, motionChallengeId);
    }

    public void deleteLikeById(long likeId) {
        motionChallengeLikeRepository.deleteById(likeId);
    }
}
