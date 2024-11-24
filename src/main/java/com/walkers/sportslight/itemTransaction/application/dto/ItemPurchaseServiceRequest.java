package com.walkers.sportslight.itemTransaction.application.dto;

import com.walkers.sportslight.itemTransaction.domain.aggregate.TransactionType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@ToString
public class ItemPurchaseServiceRequest {
    private final long userNo;
    private final long itemId;
    private final LocalDateTime createdAt;
    private final TransactionType itemTransactionType = TransactionType.PURCHASE;
}
