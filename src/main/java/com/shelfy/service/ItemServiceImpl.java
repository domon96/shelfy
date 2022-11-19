package com.shelfy.service;

import com.shelfy.model.FOOD_STATUS;
import com.shelfy.model.Item;
import com.shelfy.model.ItemDto;
import com.shelfy.model.Product;
import com.shelfy.repository.ItemRepository;
import com.shelfy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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
    public List<ItemDto> getItems() {
        return itemRepository.findByOrderByExpirationDate()
                .stream()
                .map(item -> {
                    final FOOD_STATUS foodStatus;
                    switch (item.getExpirationDate()){

                    }
                    new ItemDto(item.getProduct().getId(), item.getExpirationDate(), item.getDescription(), )
                })
    }

    @Override
    public Item addItem(int productId, LocalDate date, String description, int count) {
        final Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Product with id " + productId + " doesnt exist");
        }
        return itemRepository.save(new Item(product.get(), date, description, count));
    }

    @Override
    public void removeItem(int id) {
        itemRepository.deleteById(id);
    }
}
