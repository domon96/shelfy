package com.shelfy.service;

import com.shelfy.model.Category;
import com.shelfy.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByCategory(int id);

    Product addProduct(String name, int validDays, Category category);

    void removeProduct(int id);
}
