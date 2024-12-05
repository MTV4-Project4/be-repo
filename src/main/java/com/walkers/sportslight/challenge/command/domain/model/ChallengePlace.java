package com.walkers.sportslight.challenge.command.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChallengePlace {
    private String placeName;
    private Double longitude; // 경도
    private Double latitude; // 위도


    public ChallengePlace(String placeName, Double longitude, Double latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
