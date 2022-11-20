package com.shelfy.service;

import com.shelfy.model.Item;
import com.shelfy.model.dto.ItemDto;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {
    List<ItemDto> getItems();

    Item addItem(int productId, LocalDate date, String description, int count);

    void removeItem(int id);
}
