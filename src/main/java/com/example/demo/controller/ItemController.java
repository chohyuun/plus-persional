package com.example.demo.controller;

import com.example.demo.dto.ItemRequestDto;
import com.example.demo.dto.ItemResponseDto;
import com.example.demo.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto.getName(),
                itemRequestDto.getDescription(),
                itemRequestDto.getOwnerId(),
                itemRequestDto.getManagerId(),
                itemRequestDto.getStatus());
    }
}
