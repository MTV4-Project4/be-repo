package com.walkers.sportslight.item.command.application.dto;

import com.walkers.sportslight.item.command.domain.aggregate.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "itemImageUrl", ignore = true) // itemImageUrl 필드는 무시
    Item toItem(ItemRequestDTO itemRequest);
}
