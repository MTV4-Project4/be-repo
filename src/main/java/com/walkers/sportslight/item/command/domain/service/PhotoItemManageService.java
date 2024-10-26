package com.walkers.sportslight.item.command.domain.service;

import com.walkers.sportslight.item.command.domain.aggregate.Item;
import com.walkers.sportslight.item.command.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhotoItemManageService {

    private final ItemRepository itemRepository;

    public PhotoItemManageService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // 파일 업로드 성공시 게시글 등록 트랜잭션 진행
    @Transactional
    public void addItemWithImageUrl(Item item, String imageUrl){
        item.setItemImageUrl(imageUrl);
        itemRepository.save(item);
    }

    // 게시글 삭제 트랜잭션 성공시 파일 삭제를 위한 url 반환
    @Transactional
    public String deleteItemWithImage(Item item){
        String oldFileUrl = item.getItemImageUrl();
        itemRepository.delete(item);

        return oldFileUrl;
    }
}
