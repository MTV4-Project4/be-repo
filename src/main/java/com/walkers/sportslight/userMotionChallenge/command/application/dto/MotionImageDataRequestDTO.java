package com.walkers.sportslight.userMotionChallenge.command.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MotionImageDataRequestDTO {
    private final String url1;
    private final String url2;
}
