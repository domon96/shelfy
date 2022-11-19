package com.shelfy.controller;

import com.shelfy.model.Item;
import com.shelfy.service.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/addItem")
    @PostMapping
    public Item addItem(@RequestBody int productId, @RequestBody Instant date, @RequestBody String description, @RequestBody int count) {
        return itemService.addItem(productId, date, description, count);
    }
}