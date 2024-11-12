package com.walkers.sportslight.item.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemImageService {

    String uploadImage(MultipartFile file) throws IOException;
    void deleteImage(String imagePath) throws IOException;
}
