package com.shelfy.service;

import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ItemDto;
import com.shelfy.model.dto.ProductStatisticsDto;

import java.util.List;

public interface ProductStatisticsService {
    ProductStatistics addProductStatistics(ItemDto itemDto, boolean wasEaten, int itemsToRemove);

    List<ProductStatisticsDto> summarizeProductStatistics();
}
