package com.walkers.sportslight.motionChallenge.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MotionFileUploadService {

    String uploadFile(MultipartFile file) throws IOException;

    void deleteFile(String filePath) throws IOException;
}
