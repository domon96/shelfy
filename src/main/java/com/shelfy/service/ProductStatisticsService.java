package com.shelfy.service;

import com.shelfy.model.ProductStatistics;
import com.shelfy.model.dto.ItemDto;

import java.util.List;

public interface ProductStatisticsService {
    ProductStatistics addProductStatistic(ItemDto itemDto, boolean wasEaten, int itemsToRemove);

    List<ProductStatistics> summarizeProductStatistic();
}
