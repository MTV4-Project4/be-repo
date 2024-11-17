package com.walkers.sportslight.config.fileStorage;

import com.walkers.sportslight.common.FileUploadService;
import com.walkers.sportslight.common.LocalFileUploadService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalFileStorageConfig {

    //@Bean
    //@Profile("local")
    public FileUploadService localFileStorageService() {
        return new LocalFileUploadService();
    }

}
