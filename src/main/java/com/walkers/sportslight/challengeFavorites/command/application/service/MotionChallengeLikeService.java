package com.walkers.sportslight.challengeFavorites.command.application.service;

import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.MotionChallengeLikeMapper;
import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.MotionChallengeLike;
import com.walkers.sportslight.challengeFavorites.command.domain.repository.MotionChallengeLikeRepository;
import org.springframework.stereotype.Service;

@Service
public class MotionChallengeLikeService {

    private final MotionChallengeLikeMapper motionChallengeLikeMapper;
    private MotionChallengeLikeRepository motionChallengeLikeRepository;

    public MotionChallengeLikeService(MotionChallengeLikeRepository motionChallengeLikeRepository, MotionChallengeLikeMapper motionChallengeLikeMapper) {
        this.motionChallengeLikeRepository = motionChallengeLikeRepository;
        this.motionChallengeLikeMapper = motionChallengeLikeMapper;
    }

    public long addLike(ChallengeFavoriteAddServiceDTO challengeFavoriteAddInfo) {
        MotionChallengeLike motionChallengeLike = motionChallengeLikeMapper.toLike(challengeFavoriteAddInfo);

        return motionChallengeLikeRepository.save(motionChallengeLike).getLikeId();


    }
}
