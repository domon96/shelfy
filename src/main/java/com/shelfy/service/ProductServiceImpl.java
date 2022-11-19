package com.shelfy.service;

import com.shelfy.model.Category;
import com.shelfy.model.Product;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> getProductsByCategory(int id) {
        return List.of();
    }

    @Override
    public Product addProduct(int category, String name, Instant timestamp) {
        return null;
    }

    @Override
    public void removeProduct(int id) {
    }
}
