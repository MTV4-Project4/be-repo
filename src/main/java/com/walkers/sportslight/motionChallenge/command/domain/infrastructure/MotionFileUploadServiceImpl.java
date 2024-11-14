package com.walkers.sportslight.motionChallenge.command.domain.infrastructure;

import com.walkers.sportslight.common.FileUploadService;
import com.walkers.sportslight.common.FileUploadUtil;
import com.walkers.sportslight.motionChallenge.command.domain.service.MotionFileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MotionFileUploadServiceImpl implements MotionFileUploadService {

    private FileUploadService fileUploadService;

    public MotionFileUploadServiceImpl(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        return fileUploadService.fileUpload(
                FileUploadUtil.MOTION_REGISTER_PATH +file.getOriginalFilename(), file
        );
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        //fileUploadService.deleteFile(filePath);
    }
}
