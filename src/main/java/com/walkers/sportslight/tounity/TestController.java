package com.walkers.sportslight.tounity;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.tounity.dto.SimpleResponseDTO;
import com.walkers.sportslight.tounity.dto.SomeDataResponseDTO;
import com.walkers.sportslight.tounity.dto.SomePostResponseData;
import com.walkers.sportslight.tounity.dto.SomeRequestData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("test")
public class TestController {

    @GetMapping(produces = "application/json; charset=utf8")
    public String stringData(){
        log.info("요청 들어옴");
        return "문자열 반환";
    }

    @GetMapping ("simple")
    public SimpleResponseDTO simpleData(){
        return new SimpleResponseDTO("통신 테스트");
    }

    @GetMapping("some")
    public SomeDataResponseDTO someData(){
        log.info("someDate함수 요청옴");
        return new SomeDataResponseDTO(
                42, 33.3, "예시 응답", LocalDateTime.now()
        );
    }

    @GetMapping("apiResponse")
    public ApiResponse<?> dataResponse(){
        return ApiResponse.ok(
                new SomeDataResponseDTO(
                        42, 33.3, "예시 응답", LocalDateTime.now()
                )
        );
    }

    @PostMapping("some")
    public SomePostResponseData dataResponse(SomeRequestData someRequestData){

        log.info("{}", someRequestData);

        return new SomePostResponseData(
                someRequestData.getSomeType(),
                someRequestData.getSomeLong(),
                someRequestData.getSomeDouble(),
                someRequestData.getString(),
                "POST 요청도 잘 받아짐"
        );

    }

    @DeleteMapping(value = "some/{id}", produces = "application/json; charset=utf8")
    public String deleteSomething(@PathVariable long id){

        return id+"번 삭제될 예정";
    }

    @PutMapping(value="some/{id}", produces = "application/json; charset=utf8")
    public String putSomething(@PathVariable long id){
        return id+"번 변경될 예정";
    }

}
