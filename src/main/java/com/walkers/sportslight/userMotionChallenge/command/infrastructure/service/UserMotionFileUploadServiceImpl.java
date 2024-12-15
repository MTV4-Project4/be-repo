package com.walkers.sportslight.userMotionChallenge.command.infrastructure.service;

import com.walkers.sportslight.common.FileStorage.FileUploadService;
import com.walkers.sportslight.userMotionChallenge.command.domain.service.UserMotionFileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserMotionFileUploadServiceImpl implements UserMotionFileUploadService {

    private FileUploadService fileUploadService;

    public UserMotionFileUploadServiceImpl(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        return fileUploadService.fileUpload("motion/user/"+file.getOriginalFilename(), file);
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        fileUploadService.deleteFile(filePath);
    }

}
