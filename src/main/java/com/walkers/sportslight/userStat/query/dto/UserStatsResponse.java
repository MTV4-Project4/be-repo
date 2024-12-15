package com.walkers.sportslight.userStat.query.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;


@Getter
@Setter
@ToString
public class UserStatsResponse {
    @JsonProperty("playerLevel")
    private int userLevel;          // 유저의 레벨

    @JsonProperty("playerExperience")
    private int userExperience;
    private Map<String, StatDetail> stats;

    // StatDetail 내부 클래스
    @Getter
    public static class StatDetail {
        private int level;
        private int experience;

        public StatDetail(int level, int experience) {
            this.level = level;
            this.experience = experience;
        }

        // Getters
    }
}
