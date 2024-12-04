package com.walkers.sportslight.userStat.command.domain.service;

import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import com.walkers.sportslight.userStat.command.domain.repository.UserStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LevelService {

    private final UserStatRepository userStatRepository;
    private final ExperienceCache experienceCache;

    public void addUserExperience(long userNo, StatType statType, int toAddExp){
        UserStat userStat = userStatRepository.findByUserNoAndAndStatType(userNo, statType)
                .orElseThrow(()->new NoSuchElementException("해당 유저를 찾을 수 없습니다."));

        int newExp = userStat.getStatExperience()+toAddExp;
        int level=userStat.getLevel();
        int requireExp;

        while((requireExp=experienceCache.getRequireExperience(level))<=newExp){
            level++;
            newExp-=requireExp;
        }

        userStat.setLevel(level);
        userStat.setStatExperience(newExp);

        // statType이 경험치가 아니면 스탯 수치 추가하는 로직도 추가 예정
    }
}
