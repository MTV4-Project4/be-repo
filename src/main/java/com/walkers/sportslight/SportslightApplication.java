package com.walkers.sportslight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableFeignClient
@EnableCaching
public class SportslightApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportslightApplication.class, args);
    }

}
