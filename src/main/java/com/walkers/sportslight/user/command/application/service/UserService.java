package com.walkers.sportslight.user.command.application.service;

import com.walkers.sportslight.user.command.application.dto.UserRegistMapper;
import com.walkers.sportslight.user.command.application.dto.UserRegistServiceDTO;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
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

    public void withdrawUser(long userNo) {
        userRepository.deleteById(userNo);
    }

//    public void withdrawUserByUserId(String userId){
//        userRepository.deleteByUserId(userId);
//    }

}
