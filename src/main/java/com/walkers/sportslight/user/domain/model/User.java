package com.walkers.sportslight.user.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(unique = true)
    private String userId;

    private String nickname;
    private String password;

    private int experience;

    @Builder
    public User(String userId, String nickname, String password, int experience) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
        this.experience = experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
