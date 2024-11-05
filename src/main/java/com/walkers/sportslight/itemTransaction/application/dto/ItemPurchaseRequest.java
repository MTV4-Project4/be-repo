package com.walkers.sportslight.itemTransaction.application.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemPurchaseRequest {
    private final long userNo;
    private final long itemId;
}
