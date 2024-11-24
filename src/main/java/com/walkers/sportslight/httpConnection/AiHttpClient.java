package com.walkers.sportslight.httpConnection;

import com.walkers.sportslight.userMotionChallenge.command.application.dto.MotionImageDataRequestDTO;
import com.walkers.sportslight.userMotionChallenge.command.domain.infrastructure.VO.SimilarityResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Map;

@HttpExchange("http://metaai3.iptime.org:7900/")
public interface AiHttpClient {

    @GetExchange("test")
    Map Test();

    @PostExchange(value = "compare_images")
    SimilarityResult sendSimilarityImage(@RequestBody MotionImageDataRequestDTO data);

}
