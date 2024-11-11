package com.walkers.sportslight.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class LocalFileUploadService implements FileUploadService{

    @Value("${UPLOAD_DIR}")
    private String uploadDir;

    @Override
    public String fileUpload(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.createDirectories(filePath.getParent());
        file.transferTo(filePath.toFile());
        String imageUrl = "http://125.132.216.190:12642/api/files/" + fileName;

        return imageUrl;
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        try {
            Path path = Paths.get(filePath);
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new IOException("파일 삭제에 실패했습니다.");
        }
    }
}
