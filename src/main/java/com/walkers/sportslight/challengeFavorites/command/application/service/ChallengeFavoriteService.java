package com.walkers.sportslight.challengeFavorites.command.application.service;

import com.walkers.sportslight.challenge.application.service.ChallengeService;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteMapper;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteDeleteDTO;
import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import com.walkers.sportslight.challengeFavorites.command.domain.repository.ChallengeFavoriteRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChallengeFavoriteService {

    private ChallengeFavoriteRepository challengeFavoriteRepository;
    private ChallengeFavoriteMapper challengeFavoriteMapper;
    private ChallengeService challengeService;

    public ChallengeFavoriteService(ChallengeFavoriteRepository challengeFavoriteRepository,
                                    ChallengeFavoriteMapper challengeFavoriteMapper) {
        this.challengeFavoriteRepository = challengeFavoriteRepository;
        this.challengeFavoriteMapper = challengeFavoriteMapper;
    }

    public long addFavorite(ChallengeFavoriteAddServiceDTO challengeFavoriteInfo){
        ChallengeFavorite userFavorite = challengeFavoriteMapper.toFavorite(challengeFavoriteInfo);
        return challengeFavoriteRepository.save(userFavorite).getFavoriteId();
    }

    public void deleteFavorite(ChallengeFavoriteDeleteDTO challengeFavoriteDeleteInfo){
        challengeFavoriteRepository.deleteById(
                challengeFavoriteDeleteInfo.getFavoriteId()
        );
    }

    public void deleteFavoriteByUserAndChallengeId(long userNo, long challengeId){
        challengeFavoriteRepository.deleteChallengeFavoriteByUserNoAndChallengeId(
                userNo, challengeId);
    }

    public void deleteFavoriteByUserAndChallengeName(long userNo, String challengeName){
        Long challengeId = challengeService.findChallengeIdByName(challengeName);
        if (challengeId!=null){
            deleteFavoriteByUserAndChallengeId(userNo,challengeId);
        } else{
            log.warn("there is no favorite that has challenge name {}.", challengeName);
        }
    }

}
