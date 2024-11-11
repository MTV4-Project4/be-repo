package com.walkers.sportslight.item.command.application.service;

import com.walkers.sportslight.item.command.application.dto.ItemMapper;
import com.walkers.sportslight.item.command.application.dto.ItemRequestDTO;
import com.walkers.sportslight.item.command.domain.aggregate.Item;
import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.command.domain.repository.ItemRepository;
import com.walkers.sportslight.item.command.domain.service.ItemImageService;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper itemMapper;
    private final ItemImageService itemImageService;
    private final itemBoardService itemBoardService;

    public ItemType getItemTypeByItemId(long itemId){
        return itemBoardService.findItemById(itemId).getItemType();
    }

    public Item findItemById(long id){
        return itemBoardService.findItemById(id);
    }

    public long addItem(ItemRequestDTO itemRequest){
        Item item = itemMapper.toItem(itemRequest);
        String imageUrl;
        try {
            imageUrl = itemImageService.uploadImage(itemRequest.getItemImage());
        } catch (IOException e){
            throw new RuntimeException("파일 업로드에 실패했습니다.");
        }

        return itemBoardService.addItemInfo(item, imageUrl);
        // Sting url = itemImageService.uploadImage();
        // addItemWithImageUrl(Item, url);
    }

    public void deleteItem(long itemId){
        String toDeleteUrl = itemBoardService.deleteItemInfo(itemId);

        try{
            itemImageService.deleteImage(toDeleteUrl);
        } catch (IOException e){
            throw new RuntimeException("파일 삭제중 문제가 발생했습니다");
        }

    }


}
