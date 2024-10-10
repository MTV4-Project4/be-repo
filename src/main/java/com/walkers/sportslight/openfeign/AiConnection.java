package com.walkers.sportslight.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "aiTest", url="http://metaai2.iptime.org:7900/")
public interface AiConnection {

    @GetMapping
    String testHello();

}
