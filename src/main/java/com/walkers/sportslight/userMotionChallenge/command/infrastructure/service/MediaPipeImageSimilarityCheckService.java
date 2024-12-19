package com.walkers.sportslight.userMotionChallenge.command.infrastructure.service;

import com.walkers.sportslight.httpConnection.AiHttpClient;
import com.walkers.sportslight.motionChallenge.command.application.service.MotionChallengeService;
import com.walkers.sportslight.userMotionChallenge.command.application.dto.MotionImageDataRequestDTO;
import com.walkers.sportslight.userMotionChallenge.command.infrastructure.VO.SimilarityResult;
import com.walkers.sportslight.userMotionChallenge.command.domain.service.SimilarityCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MediaPipeImageSimilarityCheckService implements SimilarityCheckService {

    private MotionChallengeService motionChallengeService;
    private AiHttpClient aiHttpClient;

    public MediaPipeImageSimilarityCheckService(MotionChallengeService motionChallengeService, AiHttpClient aiHttpClient) {
        this.motionChallengeService = motionChallengeService;
        this.aiHttpClient = aiHttpClient;
    }

    @Override
    public SimilarityResult getSimilarity(long motionChallengeId, String userMotionFileUrl) {

        String baseMotionUrl = motionChallengeService.getMotionImageUrl(motionChallengeId);

        try {
            log.info("ai server send try, baseUrl:{}, userMotionFileUrl:{}", baseMotionUrl, userMotionFileUrl);
            SimilarityResult similarityResult =
                    aiHttpClient.sendSimilarityImage(
                            new MotionImageDataRequestDTO(
                                    baseMotionUrl, userMotionFileUrl
                            )
                    );

            return similarityResult;

        } catch (Exception e) {
            log.warn("failed to calculate similarity. baseImageUrl:{}, userMotionFileUrl:{}, exception:{}",
                    baseMotionUrl, userMotionFileUrl, e.getMessage());
            throw new RuntimeException("유사도 측정 중 오류가 발생했습니다. 오류 내용 : ", e);
        }
        //return 0;
    }

    @Override
    public String getResult(double similarity) {
        return similarity>=65? "Success":"Fail";
    }


}
