package com.walkers.sportslight.userMotionChallenge.command.domain.infrastructure.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class SimilarityResult {

    @JsonProperty("similarity_score")
    private double similarityScore;
    private String result;
}
