package com.shelfy.service;

import com.shelfy.model.Product;
import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.repository.ProductStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStatisticsServiceImpl implements ProductStatisticsService {
    private final ProductStatisticsRepository productStatisticRepository;
    private final ProductService productService;

    public ProductStatisticsServiceImpl(ProductStatisticsRepository productStatisticRepository, ProductService productService) {
        this.productStatisticRepository = productStatisticRepository;
        this.productService = productService;
    }

    @Override
    public ProductStatistics addProductStatistic(ItemDto itemDto, boolean wasEaten, int itemsToRemove) {
        Product product = productService.getProduct(itemDto.productId());
        if (wasEaten) {
            return productStatisticRepository.save(new ProductStatistics(product, 0, itemsToRemove, itemDto.date()));
        } else {
            return productStatisticRepository.save(new ProductStatistics(product, itemsToRemove, 0, itemDto.date()));
        }
    }

    @Override
    public List<ProductStatistics> summarizeProductStatistic() {
        return null;
    }
}
