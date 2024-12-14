package com.walkers.sportslight.config;

import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.user.command.domain.model.User;
import com.walkers.sportslight.user.command.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserId())
                .password(user.getPassword())
                .roles(user.getAuthority().name())
                .build();

    }
}
