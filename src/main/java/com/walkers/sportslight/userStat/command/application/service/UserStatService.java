package com.walkers.sportslight.userStat.command.application.service;

import com.walkers.sportslight.userStat.command.application.dto.UserStatMapper;
import com.walkers.sportslight.userStat.command.application.dto.UserStatUpdateRequest;
import com.walkers.sportslight.userStat.command.domain.aggregate.StatType;
import com.walkers.sportslight.userStat.command.domain.aggregate.UserStat;
import com.walkers.sportslight.userStat.command.domain.repository.UserStatRepository;
import com.walkers.sportslight.userStat.command.domain.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserStatService {

    private final UserStatRepository userStatRepository;
    private final UserStatMapper userStatMapper;
    private final LevelService levelService;

    public UserStat findById(Long id) {
        return userStatRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("User Stat not found"));

    }

    @Transactional
    //유저 정보를 만들 때 사용
    public void initUserStat(long userNo){
        StatType[] statType =  StatType.values();
        for (StatType stat : statType) {
            int initValue = stat==StatType.USER_EXPERIENCE? 0:10;
            userStatRepository.save(new UserStat(userNo, stat, 0, initValue, 1));
        }
    }

    @Transactional
    public void updateStatExperience( long userNo, UserStatUpdateRequest updateRequest){
        levelService.addUserExperience(userNo,
                updateRequest.getStatType(), updateRequest.getAddExperience());
    }

    @Transactional
    //유저 정보를 지울 때 사용
    public void deleteUserStat(long userNo){
        userStatRepository.deleteByUserNo(userNo);
    }

    @Transactional
    public void updateMultipleStats(long userNo, List<UserStatUpdateRequest> requests) {
        for (UserStatUpdateRequest request : requests) {
            // 유저 번호가 일치하는지 확인하고 개별 업데이트 수행
            updateStatExperience(userNo, request);
        }
    }

//    @Transactional
//    public void updateUserStat(UserStatUpdateRequest updateRequest) {
//        UserStat userstat = findById(userStatId);
//        userstat.update(userStatMapper.toUserStat(userStatInfo));
//    }
}
