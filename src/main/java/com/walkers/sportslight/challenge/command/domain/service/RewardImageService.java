package com.walkers.sportslight.challenge.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RewardImageService {
    String imageUpload(MultipartFile image) throws IOException;
    void deleteImage(String imagePath) throws IOException;
}
