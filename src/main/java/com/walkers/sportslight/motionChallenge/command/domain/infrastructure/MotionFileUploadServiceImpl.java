package com.walkers.sportslight.motionChallenge.command.domain.infrastructure;

import com.walkers.sportslight.common.FileStorage.FileUploadService;
import com.walkers.sportslight.common.FileStorage.FileUploadUtil;
import com.walkers.sportslight.motionChallenge.command.domain.service.MotionFileUploadService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class MotionFileUploadServiceImpl implements MotionFileUploadService {

    private FileUploadService fileUploadService;

    public MotionFileUploadServiceImpl(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        return fileUploadService.fileUpload(FileUploadUtil.MOTION_REGISTER_PATH + file.getOriginalFilename()
        ,resizeImage(file));

//        return fileUploadService.fileUpload(
//                FileUploadUtil.MOTION_REGISTER_PATH +file.getOriginalFilename(), file
//        );
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        //fileUploadService.deleteFile(filePath);
    }

    public byte[] resizeImage(MultipartFile file) throws IOException {
        BufferedImage originalImage = javax.imageio.ImageIO.read(file.getInputStream());
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        BufferedImage resizedImage = Thumbnails.of(originalImage)
                .size(originalWidth / 2, originalHeight / 2)
                .outputFormat("png")
                .asBufferedImage();

        // 리사이즈된 이미지를 바이트 배열로 변환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(resizedImage, "png", outputStream);
        byte[] resizedImageBytes = outputStream.toByteArray();

        return resizedImageBytes;

    }
}
