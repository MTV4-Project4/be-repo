package com.walkers.sportslight.user.command.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(unique = true)
    private String userId;
    private String password;
    private String nickname;
    private int age;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Authority authority;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private int experience;
    private int money;

    @Builder
    public User(String userId, String password, String nickname, int age, String phoneNumber, String address, Authority authority, UserStatus status, int experience, int money) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.authority = authority;
        this.status = status;
        this.experience = experience;
        this.money = money;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
