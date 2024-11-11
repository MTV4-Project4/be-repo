package com.walkers.sportslight.userStat.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStatId;
    private long userNo;

    @Enumerated(EnumType.STRING)
    private StatType statType; // 스탯 유형

    private int statExperience; // 경험치
    private int value; // 스탯 수치
    private int level;

    @Builder
    public UserStat(long userNo, StatType statType, int statExperience, int value, int level) {
        this.userNo = userNo;
        this.statType = statType;
        this.statExperience = statExperience;
        this.value = value;
        this.level = level;
    }

    public void update(UserStat userStat){
        this.userNo = userStat.getUserNo();
        this.statType = userStat.getStatType();
        this.statExperience = userStat.getStatExperience();
        this.value = userStat.getValue();
        this.level = userStat.getLevel();
    }

    public void setStatExperience(int statExperience) {
        this.statExperience = statExperience;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
