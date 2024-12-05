package com.walkers.sportslight.challengeFavorites.command.application.service;

import com.walkers.sportslight.challenge.command.application.service.ChallengeService;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteAddServiceDTO;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteMapper;
import com.walkers.sportslight.challengeFavorites.command.application.dto.request.ChallengeFavoriteDeleteDTO;
import com.walkers.sportslight.challengeFavorites.command.domain.aggregate.ChallengeFavorite;
import com.walkers.sportslight.challengeFavorites.command.domain.repository.ChallengeFavoriteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChallengeFavoriteService {

    private ChallengeFavoriteRepository challengeFavoriteRepository;
    private ChallengeFavoriteMapper challengeFavoriteMapper;
    private ChallengeService challengeService;

    public ChallengeFavoriteService(ChallengeFavoriteRepository challengeFavoriteRepository, ChallengeFavoriteMapper challengeFavoriteMapper, ChallengeService challengeService) {
        this.challengeFavoriteRepository = challengeFavoriteRepository;
        this.challengeFavoriteMapper = challengeFavoriteMapper;
        this.challengeService = challengeService;
    }

    @Transactional
    public long addFavorite(ChallengeFavoriteAddServiceDTO challengeFavoriteInfo){

        if (challengeFavoriteRepository.existsByUserNoAndChallengeId(
                challengeFavoriteInfo.getUserNo(), challengeFavoriteInfo.getChallengeId()
        )) {
            return challengeFavoriteRepository.findChallengeFavoriteByUserNoAndChallengeId(
                    challengeFavoriteInfo.getUserNo(), challengeFavoriteInfo.getChallengeId()
            ).get().getChallengeId();
        }

        ChallengeFavorite userFavorite = challengeFavoriteMapper.toFavorite(challengeFavoriteInfo);
        return challengeFavoriteRepository.save(userFavorite).getFavoriteId();
    }

    public void deleteFavorite(ChallengeFavoriteDeleteDTO challengeFavoriteDeleteInfo){
        challengeFavoriteRepository.deleteById(
                challengeFavoriteDeleteInfo.getFavoriteId()
        );
    }

    @Transactional
    public void deleteFavoriteByUserAndChallengeId(long userNo, long challengeId){
        challengeFavoriteRepository.deleteChallengeFavoriteByUserNoAndChallengeId(
                userNo, challengeId);
    }


    @Transactional
    public void deleteFavoriteByUserAndChallengeName(long userNo, String challengeName){

        Long challengeId = challengeService.findChallengeIdByName(challengeName);
        log.info("map challenge name {} to challengeId:{}", challengeName, challengeId);

        if (challengeId!=null){

            deleteFavoriteByUserAndChallengeId(userNo,challengeId);
        } else{
            log.warn("there is no favorite that has challenge name {}.", challengeName);
        }
    }

}
