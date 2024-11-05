package com.walkers.sportslight.item.command.application.service;

import com.walkers.sportslight.item.command.application.dto.ItemMapper;
import com.walkers.sportslight.item.command.application.dto.ItemRequestDTO;
import com.walkers.sportslight.item.command.domain.aggregate.Item;
import com.walkers.sportslight.item.command.domain.aggregate.ItemType;
import com.walkers.sportslight.item.command.domain.repository.ItemRepository;
import com.walkers.sportslight.userInventory.command.application.service.UserInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserInventoryService userInventoryService;

    public Item findItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("해당하는 아이템은 존재하지 않습니다.")
        );
    }

    public ItemType getItemTypeByItemId(long itemId){
        return findItemById(itemId).getItemType();
    }

    public void addItem(ItemRequestDTO itemRequest){
        Item item = itemMapper.toItem(itemRequest);
        // Sting url = itemImageService.uploadImage();
        // addItemWithImageUrl(Item, url);
    }

    public void deleteItem(long itemId){
        String toDeleteUrl = deleteItemWithImage(itemId);
        // itemImageService.deleteImage();
    }

    // 파일 업로드 성공시 게시글 등록 트랜잭션 진행
    @Transactional
    protected void addItemWithImageUrl(Item item, String imageUrl){
        item.setItemImageUrl(imageUrl);
        itemRepository.save(item);
    }

    // 게시글 삭제 트랜잭션 성공시 파일 삭제를 위한 url 반환
    @Transactional
    protected String deleteItemWithImage(long itemId){
        Item item = findItemById(itemId);
        String oldFileUrl = item.getItemImageUrl();
        itemRepository.deleteById(itemId);
        userInventoryService.deleteByItemId(itemId);

        return oldFileUrl;
    }
}
