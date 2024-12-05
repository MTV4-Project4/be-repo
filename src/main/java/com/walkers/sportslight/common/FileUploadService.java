package com.walkers.sportslight.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    String fileUpload(String filePath, MultipartFile file) throws IOException;
    void deleteFile(String filePath) throws IOException;
    String fileUpload(String filePath, byte[] fileBytes) throws IOException;
}
