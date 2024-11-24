package com.walkers.sportslight.httpConnection;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.MotionImageDataRequestDTO;
import com.walkers.sportslight.userMotionChallenge.command.domain.infrastructure.VO.SimilarityResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiTestController {

    private AiHttpClient aiHttpClient;

    public AiTestController(AiHttpClient aiHttpClient) {
        this.aiHttpClient = aiHttpClient;
    }

    @GetMapping("/aiTest")
    public SimilarityResult Test(){

        SimilarityResult map = aiHttpClient.sendSimilarityImage(
                new MotionImageDataRequestDTO(
                        "http://125.132.216.190:12642/api/files/269f8736-cf26-4026-89e7-0058a14f60b2_유사도_예시_4.png",
//                        "http://125.132.216.190:12642/api/files/7fb517fb-6e20-41ac-840f-d83d7b0b2df1_유사도_예시_3.png",
                        "http://125.132.216.190:12642/api/files/20292332-9af2-414b-a7df-3ed2197e6a19_유사도_예시_3.png"
//                        "http://125.132.216.190:12642/api/files/fb76ab45-48e5-40c1-bd44-569c3b3cb7ca_유사도_예시_1.png",
//                        "http://125.132.216.190:12642/api/files/05d8f458-9438-4ccd-8c5d-196e9bd3010d_유사도_예시_2.png"
                )

        );

        System.out.println(map);
        return map;
    }
}
