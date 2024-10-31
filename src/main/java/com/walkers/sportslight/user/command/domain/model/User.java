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

    @Builder
    public User(String userId, String password, String nickname, int age, String phoneNumber,
                String address, Authority authority, UserStatus status) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.authority = authority;
        this.status = status;
    }
}
