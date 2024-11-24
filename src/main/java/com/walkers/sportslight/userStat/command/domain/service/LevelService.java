package com.walkers.sportslight.userStat.command.domain.service;

import com.walkers.sportslight.user.command.domain.repository.ExperienceRepository;
import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import com.walkers.sportslight.userStat.command.domain.repository.UserStatRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LevelService {

    private ExperienceRepository experienceRepository;
    private UserStatRepository userStatRepository;

    public LevelService(ExperienceRepository experienceRepository, UserStatRepository userStatRepository) {
        this.experienceRepository = experienceRepository;
        this.userStatRepository = userStatRepository;
    }

    //일단 각 스탯 경험치도 레벨별로 동일하다고 가정
    public int getRequireExperience(int level){
        return experienceRepository.findById((long)level)
                .orElseThrow(()->new IllegalArgumentException("부적절한 접근입니다.")).getRequireExperience();
    }

    //private
    public void addUserExperience(long userNo, StatType statType, int toAddExp){
        UserStat userStat = userStatRepository.findByUserNoAndAndStatType(userNo, statType)
                .orElseThrow(()->new NoSuchElementException("해당 유저를 찾을 수 없습니다."));

        System.out.println("toAddexp : " + toAddExp);
        int newExp = userStat.getStatExperience()+toAddExp;
        int level=userStat.getLevel();
        System.out.println("level"+level);
        int requireExp;

        while((requireExp=getRequireExperience(level))<=newExp){
            level++;
            newExp-=requireExp;
        }

        userStat.setLevel(level);
        userStat.setStatExperience(newExp);

        // statType이 경험치가 아니면 스탯 수치 추가하는 로직도 추가 예정
    }
}
