package com.walkers.sportslight.user.command.application.service;

import com.walkers.sportslight.user.command.application.dto.UserAuthResponseDTO;
import com.walkers.sportslight.user.command.application.dto.UserRegistMapper;
import com.walkers.sportslight.user.command.application.dto.UserRegistServiceDTO;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import com.walkers.sportslight.user.command.domain.service.LoginService;
import com.walkers.sportslight.userStat.command.application.service.UserStatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRegistMapper userRegistMapper;
    private final LoginService loginService;
    private final UserStatService userStatService;

    public User findByUserNo(Long userNo) {
        User foundUser = userRepository.findById(userNo)
                .orElseThrow(()-> new NoSuchElementException("해당 유저 이름을 찾을 수 없습니다."));

        return foundUser;
    }

    public User findByUserId(String userId){
        return userRepository.findByUserId(userId)
                .orElseThrow(()-> new NoSuchElementException("해당 유저 이름을 찾을 수 없습니다."));
    }

    public int getUserMoney(long userNo){
        return findByUserNo(userNo).getMoney();
    }

    public void addMoney(long userNo, int money){
        User user = findByUserNo(userNo);
        user.setMoney(user.getMoney() + money);
    }

    public void subtractMoney(long userNo, int money){
        User user = findByUserNo(userNo);
        user.setMoney(user.getMoney() - money);
    }

    @Transactional
    public UserAuthResponseDTO registUser(UserRegistServiceDTO userRegistInfo) {
        User user = userRegistMapper.toUser(userRegistInfo);
        user.setPassword(loginService.encodePassword(
                user.getPassword()
        ));

        if (userRepository.existsByUserId(userRegistInfo.getUserId())){
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        User createdUser = userRepository.save(user);
        userStatService.initUserStat(createdUser.getUserNo());

        return new UserAuthResponseDTO(createdUser.getUserNo(), createdUser.getNickname());
    }

    public long loginUser(String userId, String password) {

        try{
            return loginService.login(userId, password);
        } catch (RuntimeException e) {
            log.warn("로그인 실패 userId:{}", userId);
            throw new IllegalArgumentException("아이디 또는 비밀번호를 확인하세요");
        }

    }


    public void withdrawUser(long userNo) {
        userRepository.deleteById(userNo);
    }

    public void withdrawUserByUserId(String userId){
        userRepository.deleteByUserId(userId);
    }

}
