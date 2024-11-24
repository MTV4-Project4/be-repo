package com.walkers.sportslight.itemTransaction.application.service;

import com.walkers.sportslight.item.command.application.service.ItemService;
import com.walkers.sportslight.itemTransaction.application.dto.ItemPurchaseRequest;
import com.walkers.sportslight.itemTransaction.application.dto.ItemPurchaseServiceRequest;
import com.walkers.sportslight.itemTransaction.application.dto.ItemRefundServiceRequest;
import com.walkers.sportslight.itemTransaction.application.dto.ItemTransactionMapper;
import com.walkers.sportslight.itemTransaction.domain.aggregate.ItemTransaction;
import com.walkers.sportslight.itemTransaction.domain.repository.ItemTransactionRepository;
import com.walkers.sportslight.user.command.application.service.UserService;
import com.walkers.sportslight.userInventory.command.application.dto.UserItemAddServiceDTO;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemTransactionService {

    private final ItemTransactionRepository itemTransactionRepository;
    private final ItemService itemService;
    private final ItemTransactionMapper itemTransactionMapper;
    private final UserService userService;
    private final UserInventoryService userInventoryService;

    @Transactional
    public long purchaseItem(ItemPurchaseServiceRequest itemPurchaseInfo){

        int itemPrice = itemService.findItemById(itemPurchaseInfo.getItemId()).getItemPrice();


        if (userService.getUserMoney(itemPurchaseInfo.getUserNo())<itemPrice){
            throw new IllegalArgumentException("돈이 충분하지 않습니다.");

        }

        userService.subtractMoney(itemPurchaseInfo.getUserNo(), itemPrice);

        userInventoryService.addUserInventory(
                new UserItemAddServiceDTO(
                        itemPurchaseInfo.getUserNo(),
                        itemPurchaseInfo.getItemId(),
                        itemPurchaseInfo.getCreatedAt()
                )
        );

        ItemTransaction purchaseTransaction = itemTransactionMapper.toPurchaseTransaction(
                itemPurchaseInfo
        );
        return itemTransactionRepository.save(purchaseTransaction).getItemTransactionId();
    }

    @Transactional
    public void refundItem(ItemRefundServiceRequest itemRefundInfo) {

        userInventoryService.findByItemIdAndUserNo(itemRefundInfo.getItemId(), itemRefundInfo.getUserNo());
        int itemPrice = itemService.findItemById(itemRefundInfo.getItemId()).getItemPrice();
        userService.addMoney(itemRefundInfo.getUserNo(), itemPrice);
        userInventoryService.deleteByItemId(itemRefundInfo.getItemId());

    }

}
