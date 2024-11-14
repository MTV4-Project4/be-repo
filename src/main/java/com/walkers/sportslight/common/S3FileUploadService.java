package com.walkers.sportslight.common;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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


    @Override
    public String fileUpload(String filePath, MultipartFile file) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

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
}
