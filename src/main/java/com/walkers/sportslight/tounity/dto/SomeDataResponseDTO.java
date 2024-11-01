package com.walkers.sportslight.tounity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class SomeDataResponseDTO {

    private final int number;
    private final double floatNumber;
    private final String string;
    private final LocalDateTime time;

}
