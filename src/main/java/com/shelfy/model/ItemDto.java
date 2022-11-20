package com.shelfy.model;

import org.springframework.lang.Nullable;

import java.time.LocalDate;

public record ItemDto(@Nullable Integer id, int productId, @Nullable String productName,
                      LocalDate date, String description,
                      int count, @Nullable FOOD_STATUS foodStatus) {
}
