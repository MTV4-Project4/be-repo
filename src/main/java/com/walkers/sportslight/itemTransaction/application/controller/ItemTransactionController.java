package com.walkers.sportslight.itemTransaction.application.controller;

import com.walkers.sportslight.itemTransaction.application.dto.ItemPurchaseRequest;
import com.walkers.sportslight.itemTransaction.application.dto.ItemPurchaseServiceRequest;
import com.walkers.sportslight.itemTransaction.application.dto.ItemTransactionResponseDTO;
import com.walkers.sportslight.itemTransaction.application.service.ItemTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api")
@Slf4j
public class ItemTransactionController {

    private ItemTransactionService itemTransactionService;

    public ItemTransactionController(ItemTransactionService itemTransactionService) {
        this.itemTransactionService = itemTransactionService;
    }

    @PostMapping("purchase")
    public ItemTransactionResponseDTO purchaseItem(@RequestBody ItemPurchaseRequest purchaseRequest){
        ItemPurchaseServiceRequest request = new ItemPurchaseServiceRequest(
                purchaseRequest.getUserNo(),
                purchaseRequest.getItemId(),
                LocalDateTime.now()
        );

        log.info("purchase 요청 정보:{}", request);
        return new ItemTransactionResponseDTO(itemTransactionService.purchaseItem(request));
    }

}
