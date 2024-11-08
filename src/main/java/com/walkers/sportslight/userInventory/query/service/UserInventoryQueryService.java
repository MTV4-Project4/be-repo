package com.walkers.sportslight.userInventory.query.service;

import com.walkers.sportslight.userInventory.query.dto.UserInventoryListDTO;
import com.walkers.sportslight.userInventory.query.dto.UserInventoryResponseDTO;
import com.walkers.sportslight.userInventory.query.repository.UserInventoryQueryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInventoryQueryService {

    private UserInventoryQueryRepository userInventoryQueryRepository;

    public UserInventoryQueryService(UserInventoryQueryRepository userInventoryQueryRepository) {
        this.userInventoryQueryRepository = userInventoryQueryRepository;
    }

    public UserInventoryResponseDTO findInventoryByUserNo(long userNo){
        UserInventoryResponseDTO result =  userInventoryQueryRepository.findByUserNo(userNo);
        if(result==null){
            return new UserInventoryResponseDTO(userNo, new ArrayList<>());
        }
        return result;
    }

    //public List<UserInventoryResponseDTO>
}
