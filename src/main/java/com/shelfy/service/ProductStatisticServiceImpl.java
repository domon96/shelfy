package com.shelfy.service;

import com.shelfy.model.Product;
import com.shelfy.model.ProductStatistic;
import com.shelfy.model.dto.ProductStatisticDto;
import com.shelfy.repository.ProductStatisticRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductStatisticServiceImpl implements ProductStatisticService {
    private final ProductStatisticRepository productStatisticRepository;
    private final ProductService productService;

    public ProductStatisticServiceImpl(ProductStatisticRepository productStatisticRepository, ProductService productService) {
        this.productStatisticRepository = productStatisticRepository;
        this.productService = productService;
    }

    @Override
    public ProductStatistic addProductStatistic(int id, int quantity, boolean wasEaten) {
        Product product = productService.getProduct(id);
        if (wasEaten) {
            return productStatisticRepository.save(new ProductStatistic(product, 0, quantity, LocalDate.now()));
        } else {
            return productStatisticRepository.save(new ProductStatistic(product, quantity, 0, LocalDate.now()));
        }
    }

    @Override
    public List<ProductStatisticDto> summarizeProductStatistic() {
        return productStatisticRepository.findByGroupedByProduct();
    }
}
