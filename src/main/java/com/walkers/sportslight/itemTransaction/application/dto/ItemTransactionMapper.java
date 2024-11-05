package com.walkers.sportslight.itemTransaction.application.dto;

import com.walkers.sportslight.itemTransaction.domain.aggregate.ItemTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItemTransactionMapper {
    ItemTransactionMapper INSTANCE = Mappers.getMapper(ItemTransactionMapper.class);

    ItemTransaction toPurchaseTransaction(ItemPurchaseServiceRequest itemPurchaseService);

    ItemTransaction toRefundTransaction(ItemRefundServiceRequest itemRefundService);
}
