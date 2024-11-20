package com.walkers.sportslight.userMotionChallenge.command.application.service;

import com.walkers.sportslight.motionChallenge.command.application.service.MotionChallengeService;
import com.walkers.sportslight.userMotionChallenge.command.domain.aggregate.UserMotionChallenge;
import com.walkers.sportslight.userMotionChallenge.command.domain.repository.UserMotionChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserMotionBoardService {

    private final MotionChallengeService motionChallengeService;
    private final UserMotionChallengeRepository userMotionChallengeRepository;

    @Transactional
    public UserMotionChallenge addUserMotionChallenge(UserMotionChallenge userMotionChallenge,
                                       String motionFileUrl,
                                       double similarity
                                       ){

        userMotionChallenge.setUserMotionFileUrl(motionFileUrl);
        userMotionChallenge.setSimilarity(similarity);

        motionChallengeService.updateParticipate(userMotionChallenge.getMotionChallengeId(),
                1);
        return userMotionChallengeRepository.save(userMotionChallenge);
    }

    @Transactional
    public void deleteUserMotionChallenge(long userMotionChallengeId){

        UserMotionChallenge userMotionChallenge = userMotionChallengeRepository.findById(
                userMotionChallengeId
        ).orElseThrow(()-> new NoSuchElementException("해당하는 모션 챌린지를 찾을 수 없습니다"));

        motionChallengeService.updateParticipate(userMotionChallenge.getMotionChallengeId(),
                -1);
        userMotionChallengeRepository.delete(userMotionChallenge);
    }
}
