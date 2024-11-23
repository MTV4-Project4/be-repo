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
    private Birthday birthday;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private Authority authority;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private int money;

    private double height;
    private double weight;

    @Builder
    public User(String userId, String password, String nickname, Birthday birthday, String phoneNumber, String address, Authority authority, UserStatus status, int money, double height, double weight) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.authority = authority;
        this.status = status;
        this.money = money;
        this.height = height;
        this.weight = weight;
    }


    public void setMoney(int money) {
        this.money = money;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
