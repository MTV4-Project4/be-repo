package com.walkers.sportslight.tounity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SomeRequestData {
    private final SomeType someType;
    private final long someLong;
    private final double someDouble;
    private final String string;
}
