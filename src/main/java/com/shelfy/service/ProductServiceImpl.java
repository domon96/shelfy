package com.shelfy.service;

import com.shelfy.model.Category;
import com.shelfy.model.Product;
import com.shelfy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new IllegalArgumentException("Product id doesnt exist");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public Product addProduct(String name, int validDays, Category category) {
        return productRepository.save(new Product(name, validDays, category));
    }
}
