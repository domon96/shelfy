package com.shelfy.service;

import com.shelfy.model.FoodStatus;
import com.shelfy.model.Item;
import com.shelfy.model.Product;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.repository.ItemRepository;
import com.shelfy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                    final FoodStatus foodStatus;
                    final LocalDate today = LocalDate.now();
                    long differenceInDays = ChronoUnit.DAYS.between(today, item.getExpirationDate());
                    if (differenceInDays < 0) foodStatus = FoodStatus.EXPIRED;
                    else if (differenceInDays < 2) foodStatus = FoodStatus.ALMOST_EXPIRED;
                    else if (differenceInDays < 4) foodStatus = FoodStatus.EXPIRING;
                    else foodStatus = FoodStatus.FRESH;
                    return new ItemDto(item.getId(), item.getProduct().getId(), item.getProduct().getName(), item.getExpirationDate(), item.getDescription(), item.getCount(), foodStatus);
                })
                .collect(Collectors.toList());
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
    public int removeItems(ItemDto itemDto) {
        assert itemDto.id() != null;
        return itemRepository.findById(itemDto.id())
                .map(item -> {
                    final int itemsLeft = item.getCount() - itemDto.count();
                    if (itemsLeft > 0) {
                        item.setCount(itemsLeft);
                        itemRepository.save(item);
                        return itemDto.count();
                    } else {
                        itemRepository.deleteById(itemDto.id());
                        return item.getCount();
                    }
                })
                .orElse(0);
    }
}
