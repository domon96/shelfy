package com.shelfy.service;

import com.shelfy.model.Category;
import com.shelfy.model.Product;
import com.shelfy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public Product addProduct(String name, int validDays, Category category) {
        return productRepository.save(new Product(name, validDays, category));
    }

    @Override
    public void removeProduct(int id) {
    }
}
