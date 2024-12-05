package com.walkers.sportslight.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.UUID;

public class LocalFileUploadService implements FileUploadService{

    //@Value("${UPLOAD_DIR}")
    private String uploadDir="/";

    public String originalFileName(MultipartFile file){
        return
                Normalizer.normalize(file.getOriginalFilename(), Normalizer.Form.NFC);
    }

    @Override
    public String fileUpload(String filePath, MultipartFile file) throws IOException {
        String fileName = (UUID.randomUUID().toString() + "_" + originalFileName(file)).replaceAll(" ", "_");
        Path uploadPath = Paths.get(uploadDir, fileName);
        Files.createDirectories(uploadPath.getParent());
        file.transferTo(uploadPath.toFile());
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

    @Override
    public String fileUpload(String filePath, byte[] fileBytes) throws IOException {
        return "";
    }

}
