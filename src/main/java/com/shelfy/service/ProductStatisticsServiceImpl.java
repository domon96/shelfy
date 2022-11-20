package com.shelfy.service;

import com.shelfy.model.Product;
import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.model.dto.ProductStatisticsDto;
import com.shelfy.repository.ProductStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStatisticsServiceImpl implements ProductStatisticsService {
    private final ProductStatisticsRepository productStatisticsRepository;
    private final ProductService productService;

    public ProductStatisticsServiceImpl(ProductStatisticsRepository productStatisticsRepository, ProductService productService) {
        this.productStatisticsRepository = productStatisticsRepository;
        this.productService = productService;
    }

    @Override
    public ProductStatistics addProductStatistics(ItemDto itemDto, boolean wasEaten, int itemsToRemove) {
        Product product = productService.getProduct(itemDto.productId());
        if (wasEaten) {
            return productStatisticsRepository.save(new ProductStatistics(product, 0, itemsToRemove, itemDto.date()));
        } else {
            return productStatisticsRepository.save(new ProductStatistics(product, itemsToRemove, 0, itemDto.date()));
        }
    }

    @Override
    public List<ProductStatisticsDto> summarizeProductStatistics() {
        return productStatisticsRepository.getProductStatistics();
    }
}
