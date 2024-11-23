package com.walkers.sportslight.user.query.service;

import com.walkers.sportslight.user.query.dto.AccountInfoResponseDTO;
import com.walkers.sportslight.user.query.repository.UserQueryRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserQueryService {
    private UserQueryRepository userQueryRepository;

    public UserQueryService(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    public AccountInfoResponseDTO findAccountByUserNo(long userNo){
        return userQueryRepository.findAccountByUserNo(userNo)
                .orElseThrow(()-> new NoSuchElementException("해당 유저를 찾을 수 없습니다."));
    }
}
