package com.walkers.sportslight.common.FileStorage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//@RestController
//@RequestMapping("api/files")
public class LocalFileUploadController {
    //@Value("${UPLOAD_DIR}")
    private String uploadDir="/";

    private FileUploadService fileStorageService;

    public LocalFileUploadController(FileUploadService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping(produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            //System.out.println(uploadDir);

            String fileUrl = fileStorageService.fileUpload("test/"+file.getOriginalFilename(), file);
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
        }
    }

    @GetMapping("{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        try {
            //System.out.println(uploadDir);
            Path filePath = Paths.get(uploadDir, fileId);
            Resource resource = new FileSystemResource(filePath);

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            // 파일의 Content-Type 설정
            String contentType = Files.probeContentType(filePath);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "application/octet-stream")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
