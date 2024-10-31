package com.walkers.sportslight.item.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface ItemImageService {

    String uploadImage(MultipartFile file);
    void deleteImage(String imagePath);
}
