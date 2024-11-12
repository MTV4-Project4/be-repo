package com.walkers.sportslight.userStat.query.service;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import com.walkers.sportslight.userStat.query.dto.*;
import com.walkers.sportslight.userStat.query.repository.UserStatQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserStatQueryService {

    private final UserStatQueryRepository userStatQueryRepository;

    public UserStatsResponse getUserStats(long userNo) {
        List<UserStatDTO> statsData = userStatQueryRepository.getUserStats(userNo);
        UserStatsResponse response = new UserStatsResponse();

        Map<String, UserStatsResponse.StatDetail> stats = new HashMap<>();
        int userExperience = 0;
        int userLevel = 1;

        for (UserStatDTO stat : statsData) {
            if (stat.getStatType() == StatType.USER_EXPERIENCE) {
                userExperience = stat.getStatExperience();
                userLevel = stat.getStatLevel();
            } else {
                String statKey = stat.getStatType().getCamelCase();
                UserStatsResponse.StatDetail statDetail = new UserStatsResponse.StatDetail(stat.getStatLevel(), stat.getStatExperience());
                stats.put(statKey, statDetail);
            }
        }

        response.setUserLevel(userLevel);
        response.setUserExperience(userExperience);
        response.setStats(stats);

        return response;
    }


}
