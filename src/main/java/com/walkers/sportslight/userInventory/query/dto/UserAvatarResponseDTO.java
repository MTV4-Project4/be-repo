package com.walkers.sportslight.userInventory.query.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class UserAvatarResponseDTO {
    private long userNo;
    private List<AvatarDTO> avatars;
}
