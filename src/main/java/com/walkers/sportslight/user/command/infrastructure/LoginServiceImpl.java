package com.walkers.sportslight.user.command.infrastructure;

import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import com.walkers.sportslight.user.command.domain.service.LoginService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public LoginServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public long login(String userId, String password) {
        User user = userRepository.findByUserId(userId).orElseThrow(
                ()->new NoSuchElementException("해당하는 유저가 없습니다")
        );

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }


        return user.getUserNo();
    }
}
