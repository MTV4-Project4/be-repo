package com.walkers.sportslight.openfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    private AiConnection aiConnection;

    public TestController(AiConnection aiConnection) {
        this.aiConnection = aiConnection;
    }

    @GetMapping("/testHello")
    public String testHello() {
        String recieveMessage = aiConnection.testHello();
        log.info(recieveMessage);
        return recieveMessage;
    }


}
