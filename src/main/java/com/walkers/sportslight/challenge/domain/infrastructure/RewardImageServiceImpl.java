package com.walkers.sportslight.challenge.domain.infrastructure;

import com.walkers.sportslight.challenge.domain.service.RewardImageService;
import com.walkers.sportslight.common.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RewardImageServiceImpl implements RewardImageService {
    private FileUploadService fileUploadService;

    public RewardImageServiceImpl(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Override
    public String imageUpload(MultipartFile image) throws IOException {

        return fileUploadService.fileUpload("reward/"+image.getOriginalFilename(), image);
    }

    @Override
    public void deleteImage(String imagePath) throws IOException {
        fileUploadService.deleteFile(imagePath);
    }
}
