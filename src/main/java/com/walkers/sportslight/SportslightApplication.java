package com.walkers.sportslight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableFeignClient
@EnableCaching
@EnableJpaAuditing
public class SportslightApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportslightApplication.class, args);
    }

}
