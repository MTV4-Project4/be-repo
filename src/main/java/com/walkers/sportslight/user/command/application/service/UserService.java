package com.walkers.sportslight.user.command.application.service;

import com.walkers.sportslight.user.command.application.dto.UserRegistMapper;
import com.walkers.sportslight.user.command.application.dto.UserRegistServiceDTO;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private UserRegistMapper userRegistMapper;

    public UserService(UserRepository userRepository, UserRegistMapper userRegistMapper) {
        this.userRepository = userRepository;
        this.userRegistMapper = userRegistMapper;
    }

    public void registUser(UserRegistServiceDTO userRegistInfo) {
        User user = userRegistMapper.toUser(userRegistInfo);
        userRepository.save(user);
    }

    public void loginUser(String userId, String password) {

        try{
            User user = userRepository.findByUserId(userId).orElseThrow(
                    ()-> new IllegalArgumentException("아이디 또는 비밀번호를 확인하세요")
            );

            log.info("로그인 성공: ID {}", userId);

        } catch (RuntimeException e) {
            throw new IllegalArgumentException("아이디 또는 비밀번호를 확인하세요");
        }


    }

    private void checkValidPassword(String rawPassword, String encodedPassword) {

        //log.info("{} {}", rawPassword, encodedPassword);

//        if(!passwordEncoder.matches(rawPassword, encodedPassword)) {
//            throw new ApplicationException(ErrorCode.INVALID_PASSWORD);
//        }
    }

    public void withdrawUser(long userNo) {
        userRepository.deleteById(userNo);
    }

//    public void withdrawUserByUserId(String userId){
//        userRepository.deleteByUserId(userId);
//    }

}
