package com.walkers.sportslight.tounity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SomePostResponseData {
    private final SomeType someType;
    private final long someLong;
    private final double someDouble;
    private final String respString;
    private final String message;
}
