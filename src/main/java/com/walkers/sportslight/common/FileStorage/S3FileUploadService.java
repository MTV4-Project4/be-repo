package com.walkers.sportslight.common.FileStorage;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class S3FileUploadService implements FileUploadService{

    private AmazonS3Client amazonS3Client;

    public S3FileUploadService(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final String MOTION_REGISTER_DIR = "motion/register";
    private final String MOTION_PLAYER_DIR = "motion/user";

    public String addUUID(String filePath) throws IOException {
        // 파일 경로에서 파일 이름 추출
        int lastSlashIndex = filePath.lastIndexOf("/");
        if (lastSlashIndex == -1) {
            throw new IOException("filePath에 '/'가 포함되지 않았습니다: " + filePath);
        }
        String originalFileName = filePath.substring(lastSlashIndex + 1);
        String originalPath = filePath.substring(0, lastSlashIndex);

        // 확장자 추출
        String fileExtension = "";
        int lastDotIndex = originalFileName.lastIndexOf(".");
        if (lastDotIndex > 0) {
            fileExtension = originalFileName.substring(lastDotIndex);
            originalFileName = originalFileName.substring(0, lastDotIndex);
        }

        // UUID 추가한 새 파일 이름 생성
        String uuid = UUID.randomUUID().toString();
        String newFileName = uuid + "_" + originalFileName + fileExtension;

        // 새로운 filePath 생성
        return originalPath + "/" + newFileName;
    }



    @Override
    public String fileUpload(String filePath, MultipartFile file) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        filePath = addUUID(filePath);

        try{
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    bucket,
                    filePath,
                    file.getInputStream(),
                    metadata
            );

            amazonS3Client.putObject(putObjectRequest);

            String uploadedUrl = amazonS3Client.getUrl(bucket, filePath).toString();
            log.info("Successfully uploaded file {}, uploaded url:{}", filePath, uploadedUrl);
            return uploadedUrl;

        } catch (Exception e){
            log.warn("failed to upload file " + filePath, e);
            throw new IOException("파일 업로드에 실패했습니다.", e);
        }

    }

    @Override
    public void deleteFile(String fileName) throws IOException {

    }

    @Override
    public String fileUpload(String filePath, byte[] fileBytes) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/png");
        metadata.setContentLength(fileBytes.length);
        filePath = addUUID(filePath);


        try{
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                    bucket,
                    filePath,
                    new ByteArrayInputStream(fileBytes),
                    metadata
            );

            amazonS3Client.putObject(putObjectRequest);

            String uploadedUrl = amazonS3Client.getUrl(bucket, filePath).toString();
            log.info("Successfully uploaded file {}, uploaded url:{}", filePath, uploadedUrl);
            return uploadedUrl;

        } catch (Exception e){
            log.warn("failed to upload file " + filePath, e);
            throw new IOException("파일 업로드에 실패했습니다.", e);
        }
    }
}
