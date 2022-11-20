package com.shelfy.service;

import com.shelfy.model.ProductStatistic;
import java.util.List;

public interface ProductStatisticService {
    ProductStatistic addProductStatistic(int id, int quantity, boolean wasEaten);
    List<ProductStatistic> summarizeProductStatistic();
}
