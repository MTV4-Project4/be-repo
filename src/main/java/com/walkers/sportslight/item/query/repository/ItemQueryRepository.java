package com.walkers.sportslight.item.query.repository;

import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.query.dto.ItemResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemQueryRepository {

    List<ItemResponseDTO> findByItemType(ItemType type);

    List<ItemResponseDTO> findItems();

    ItemResponseDTO findById(long itemId);
}
