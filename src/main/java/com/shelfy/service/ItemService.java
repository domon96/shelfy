package com.shelfy.service;

import com.shelfy.model.Item;

import java.time.LocalDate;
import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item addItem(int productId, LocalDate date, String description, int count);

    void removeItem(int id);
}
