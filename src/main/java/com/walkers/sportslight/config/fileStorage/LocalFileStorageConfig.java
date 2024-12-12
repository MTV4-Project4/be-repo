package com.walkers.sportslight.config.fileStorage;

import com.walkers.sportslight.common.FileStorage.FileUploadService;
import com.walkers.sportslight.common.FileStorage.LocalFileUploadService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalFileStorageConfig {

    //@Bean
    //@Profile("local")
    public FileUploadService localFileStorageService() {
        return new LocalFileUploadService();
    }

}
