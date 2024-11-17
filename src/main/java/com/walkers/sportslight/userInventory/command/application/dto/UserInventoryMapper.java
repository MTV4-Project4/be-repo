package com.walkers.sportslight.userInventory.command.application.dto;

import com.walkers.sportslight.userInventory.command.domain.aggregate.UserInventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserInventoryMapper {
    UserInventoryMapper INSTANCE = Mappers.getMapper(UserInventoryMapper.class);

    UserInventory toUserInventory(UserItemAddServiceDTO userItemAddInfo);
}
