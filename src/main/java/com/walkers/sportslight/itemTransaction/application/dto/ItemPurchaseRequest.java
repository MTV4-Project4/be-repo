package com.walkers.sportslight.itemTransaction.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ItemPurchaseRequest {
    private final long userNo;
    private final long itemId;
}
