package com.shelfy.service;

import com.shelfy.model.ProductStatistic;
import com.shelfy.model.dto.ProductStatisticDto;

import java.util.List;

public interface ProductStatisticService {
    ProductStatistic addProductStatistic(int id, int quantity, boolean wasEaten);
    List<ProductStatisticDto> summarizeProductStatistic();
}
