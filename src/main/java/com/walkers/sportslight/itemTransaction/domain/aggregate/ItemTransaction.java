package com.walkers.sportslight.itemTransaction.domain.aggregate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemTransactionId;

    private long itemId;
    private long userNo;
    private TransactionType itemTransactionType;
    //private int amount;
    private LocalDateTime createdAt;

    @Builder
    public ItemTransaction(long itemId, long userNo, TransactionType itemTransactionType, LocalDateTime createdAt) {
        this.itemId = itemId;
        this.userNo = userNo;
        this.itemTransactionType = itemTransactionType;
        //this.amount = amount;
        this.createdAt = createdAt;
    }
}
