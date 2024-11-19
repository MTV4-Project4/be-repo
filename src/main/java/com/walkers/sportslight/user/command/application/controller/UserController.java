package com.walkers.sportslight.user.command.application.controller;

import com.walkers.sportslight.user.command.application.dto.UserAuthRequestDTO;
import com.walkers.sportslight.user.command.application.dto.UserRegistServiceDTO;
import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.model.Birthday;
import com.walkers.sportslight.user.command.domain.model.Authority;
import com.walkers.sportslight.user.command.domain.model.UserStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@Tag(name = "유저 API", description = "유저 정보와 로그인을 관리하는 API")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("user")
//    public void registUser(@RequestBody UserRegistRequestDTO userInfo){
//
//        UserRegistServiceDTO userRegistInfo = new UserRegistServiceDTO(userInfo, Authority.USER, UserStatus.ACTIVE);
//        userService.registUser(userRegistInfo);
//    }

//    @Operation(summary = "로그인", description = "회원 로그인을 처리하고 인증 토큰을 발급합니다.")
//    @PostMapping("login")
    @Operation(summary = "회원 가입", description = "회원 가입을 처리합니다.")
    @PostMapping("/signup")
    public void signup(@RequestBody UserAuthRequestDTO.signUpDTO signInfo){

        UserRegistServiceDTO userRegistInfo = new UserRegistServiceDTO(
                signInfo, Authority.USER, UserStatus.ACTIVE,
                new Birthday(signInfo.year(), signInfo.month(), signInfo.day()));
        log.info("회원 가입 정보 : {}", userRegistInfo);
        userService.registUser(userRegistInfo);
    }


    @Operation(summary = "로그인", description = "로그인을 처리합니다.")
    @PostMapping("/login")
    public long login(HttpServletRequest httpServletRequest,  @RequestBody UserAuthRequestDTO.loginDTO loginInfo){

        String ipAddress = httpServletRequest.getRemoteAddr();

        log.info("로그인 시도, 아이디:{}, ip 주소:{}", loginInfo.userId(), ipAddress);

        long userNo =  userService.loginUser(loginInfo.userId(), loginInfo.password());
        log.info("유저 {} 로그인 성공, 아이디:{}, ip 주소:{}", userNo, loginInfo.userId(), ipAddress);
        return userNo;
    }


}
