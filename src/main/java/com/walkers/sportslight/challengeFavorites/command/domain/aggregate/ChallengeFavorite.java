package com.walkers.sportslight.challengeFavorites.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ChallengeFavorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private long userNo;
    private long challengeId;
    private LocalDateTime addedDate;

    @Builder
    public ChallengeFavorite(long userNo, long challengeId, LocalDateTime addedDate) {
        this.userNo = userNo;
        this.challengeId = challengeId;
        this.addedDate = addedDate;
    }
}
