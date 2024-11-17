package com.walkers.sportslight.userMotionChallenge.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserMotionFileUploadService {
    public String uploadFile(MultipartFile file) throws IOException;

    void deleteFile(String filePath) throws IOException;
}
