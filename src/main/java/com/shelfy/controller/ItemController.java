package com.shelfy.controller;

import com.shelfy.model.Item;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.service.ItemService;
import com.shelfy.service.ProductStatisticsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class ItemController {
    private final ItemService itemService;
    private final ProductStatisticsService productStatisticsService;

    public ItemController(ItemService itemService, ProductStatisticsService productStatisticsService) {
        this.itemService = itemService;
        this.productStatisticsService = productStatisticsService;
    }

    @RequestMapping("/getItems")
    @GetMapping
    public List<ItemDto> getItems() {
        return itemService.getItems();
    }

    @RequestMapping("/addItem")
    @PostMapping
    public Item addItem(@RequestBody ItemDto itemDto) {
        return itemService.addItem(itemDto.productId(), itemDto.date(), itemDto.description(), itemDto.count());
    }

    @RequestMapping("/removeItem")
    @PutMapping
    public void removeItem(@RequestBody ItemDto itemDto, @RequestParam boolean wasEaten) {
        final int itemsToRemove = itemService.removeItems(itemDto);
        productStatisticsService.addProductStatistic(itemDto, wasEaten, itemsToRemove);
    }
}
