package com.walkers.sportslight.userMotionChallenge.command.application.service;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddResponseDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserChallengeAddServiceDTO;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.UserMotionChallengeMapper;
import com.walkers.sportslight.userMotionChallenge.command.domain.aggregate.UserMotionChallenge;
import com.walkers.sportslight.userMotionChallenge.command.domain.repository.UserMotionChallengeRepository;
import com.walkers.sportslight.userMotionChallenge.command.domain.service.SimilarityCheckService;
import com.walkers.sportslight.userMotionChallenge.command.domain.service.UserMotionFileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserMotionChallengeService {

    private final UserMotionChallengeRepository userMotionChallengeRepository;
    private final UserMotionFileUploadService userMotionFileUploadService;
    private final UserMotionBoardService userMotionBoardService;
    private final SimilarityCheckService similarityCheckService;
    private final UserMotionChallengeMapper userMotionChallengeMapper;

    public UserChallengeAddResponseDTO addUserMotionChallenge(UserChallengeAddServiceDTO userChallengeAddInfo){
        String userMotionUrl=null;
        try{
            userMotionUrl = userMotionFileUploadService.uploadFile(userChallengeAddInfo.getAddImage());
        } catch (IOException e){
            throw new RuntimeException("파일 업로드에 실패했습니다");
        }

        double similarity = similarityCheckService.getSimilarity(
                userChallengeAddInfo.getMotionChallengeId(),
                userMotionUrl
        );

        UserMotionChallenge userMotionChallenge = userMotionChallengeMapper.toUserMotionChallenge(
                userChallengeAddInfo
        );

        UserMotionChallenge registeredChallenge = userMotionBoardService.addUserMotionChallenge(
                userMotionChallenge, userMotionUrl, similarity);
        return new UserChallengeAddResponseDTO(
                registeredChallenge.getUserMotionId(), registeredChallenge.getSimilarity()
        );



    }



}
