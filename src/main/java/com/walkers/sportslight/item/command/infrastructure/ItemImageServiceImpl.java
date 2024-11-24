package com.walkers.sportslight.item.command.infrastructure;

import com.walkers.sportslight.common.FileUploadService;
import com.walkers.sportslight.item.command.domain.service.ItemImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ItemImageServiceImpl implements ItemImageService {

    private FileUploadService fileUploadService;

    public ItemImageServiceImpl(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        return fileUploadService.fileUpload("rewardImage/", file);
    }

    @Override
    public void deleteImage(String imagePath) throws IOException {
        fileUploadService.deleteFile(imagePath);
    }
}
