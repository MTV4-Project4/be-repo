package com.walkers.sportslight.challenge.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long challengeId;

    private String title;
    private String content;
    private int participantCount;
    private int capacity;

    public Challenge(String title, String content, int participantCount, int capacity) {
        this.title = title;
        this.content = content;
        this.participantCount = participantCount;
        this.capacity = capacity;
    }
}
