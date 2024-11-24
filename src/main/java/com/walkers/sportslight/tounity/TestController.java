package com.walkers.sportslight.tounity;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.tounity.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping
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
        log.info("someData 함수 get 요청옴");
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

        log.info("pose 요청 옴, 내용 : {}", someRequestData);

        return new SomePostResponseData(
                someRequestData.getSomeType(),
                someRequestData.getSomeLong(),
                someRequestData.getSomeDouble(),
                someRequestData .getReqString(),
                "POST 요청도 잘 받아짐"
        );

    }

    @DeleteMapping(value = "some/{id}", produces = "application/json; charset=utf8")
    public String deleteSomething(@PathVariable long id){
        log.info("delete 함수 옴, id:{}", id);
        return id+"번 삭제될 예정";
    }

    @PutMapping(value="some/{id}", produces = "application/json; charset=utf8")
    public String putSomething(@PathVariable long id, @RequestBody SomePutRequestDTO putData){
        log.info("put 요청 옴, putData:{}", putData);
        //System.out.println(putData);
        return id+"번 변경될 예정";
    }

}
