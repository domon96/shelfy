package com.shelfy.service;

import com.shelfy.model.Item;
import com.shelfy.model.Product;
import com.shelfy.repository.ItemRepository;
import com.shelfy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ProductRepository productRepository,
                           ItemRepository itemRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(int productId, Instant date, String description, int count) {
        final Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            return null;
        }
        return itemRepository.save(new Item(product.get(), date, description, count));
    }
}
