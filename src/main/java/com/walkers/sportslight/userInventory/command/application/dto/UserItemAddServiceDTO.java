package com.walkers.sportslight.userInventory.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserItemAddServiceDTO {
    private final long userId;
    private final long itemId;
    private final LocalDateTime acquireAt;
}
