package com.walkers.sportslight.challenge.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RewardImageService {
    String imageUpload(MultipartFile image) throws IOException;
    void deleteImage(String imagePath) throws IOException;
}
