package com.shelfy.service;

import com.shelfy.model.Item;

import java.time.Instant;
import java.util.List;

public interface ItemService {
    List<Item> getItems();

    Item addItem(int productId, Instant date, String description, int count);

    void removeItem(int id);
}
