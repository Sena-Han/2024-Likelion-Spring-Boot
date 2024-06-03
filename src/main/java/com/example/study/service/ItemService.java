package com.example.study.service;

import com.example.study.dto.item.UpdateItemRequest;
import com.example.study.entity.Item;
import com.example.study.model.AddItemInput;
import com.example.study.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public long addItem(AddItemInput input) {
        Item item = Item.builder()
                .name(input.getItemName())
                .description(input.getItemDescription())
                .startingPrice(String.valueOf(input.getItemStartingPrice()))
                .build();
        Item saved = itemRepository.save(item);
        return saved.getId();
    }

    public void updateItem(long id, UpdateItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 item이 없음"));

        int currentStartingPrice = Integer.parseInt(item.getStartingPrice());

        if(request.getItemPrice() < currentStartingPrice){
            throw new RuntimeException("등록된 가격보다 더 높은 가격으로만 수정할 수 있음");
        }

        item.setDescription(request.getItemDescription());
        item.setStartingPrice(String.valueOf(request.getItemPrice()));

        itemRepository.save(item);
    }
}