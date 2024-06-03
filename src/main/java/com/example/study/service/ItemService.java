package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.entity.BookUpdateHistory;
import com.example.study.entity.Item;
import com.example.study.model.AddBookInput;
import com.example.study.model.AddItemInput;
import com.example.study.model.UpdateItemInput;
import com.example.study.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public void updateItem(long id, UpdateItemInput input) {
        Item item = itemRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 item이 없음"));

        int currentStartingPrice = Integer.parseInt(item.getStartingPrice());

        if(input.getItemPrice() < currentStartingPrice){
            throw new RuntimeException("등록된 가격보다 더 높은 가격으로만 수정할 수 있음");
        }

        item.setDescription(input.getItemDescription());
        item.setStartingPrice(String.valueOf(input.getItemPrice()));

        itemRepository.save(item);
    }
}