package com.walkers.sportslight.item.query.controller;

import com.walkers.sportslight.api.ApiResponse;
import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.query.dto.ItemResponseDTO;
import com.walkers.sportslight.item.query.service.ItemQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@Tag(name = "아이템 조회 API", description = "아이템의 정보를 조회하기 위한 API")
public class ItemQueryController {

    private ItemQueryService itemQueryService;

    public ItemQueryController(ItemQueryService itemQueryService) {
        this.itemQueryService = itemQueryService;
    }

//    public ApiResponse<?> findItemByType(@ModelAttribute ItemType itemType){
//        return ApiResponse.ok(itemQueryService.findByItemType(itemType));
//    }

    @Operation(summary = "아이템 목록 조회", description = "상점에서 파는 아이템 목록을 조회함, 타입별로 조회가능")
    @GetMapping("item")
    public List<ItemResponseDTO> findItemByType(@ModelAttribute ItemType itemType){
        if(itemType == null){
            return itemQueryService.findItems();
        }
        
        return itemQueryService.findByItemType(itemType);
    }

    @Operation(summary = "개별 아이템 목록 조회")
    @GetMapping("item/{itemId}")
    public ItemResponseDTO findItemById(@PathVariable long itemId){
        return itemQueryService.findById(itemId);
    }


}
