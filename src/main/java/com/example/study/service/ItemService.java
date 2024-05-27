package com.example.study.service;

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
}