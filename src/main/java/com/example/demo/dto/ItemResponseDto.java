package com.example.demo.dto;

import com.example.demo.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
    private String name;
    private String description;
    private Long managerId;
    private Long ownerId;

    public ItemResponseDto(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.managerId = item.getManager().getId();
        this.ownerId = item.getOwner().getId();
    }
}
