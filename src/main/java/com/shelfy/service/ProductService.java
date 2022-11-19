package com.shelfy.service;

import com.shelfy.model.Product;

import java.time.Instant;
import java.util.List;

public interface ProductService {
    List<Product> getProductsByCategory(int id);

    Product addProduct(int category, String name, Instant timestamp);

    void removeProduct(int id);
}
