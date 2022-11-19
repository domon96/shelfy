package com.shelfy.service;

import com.shelfy.model.Item;

import java.time.Instant;

public interface ItemService {
    Item addItem(int productId, Instant date, String description, int count);
}
