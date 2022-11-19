package com.shelfy.model;

import org.springframework.lang.Nullable;

import java.time.LocalDate;

public record ItemDto(@Nullable int id, int productId, LocalDate date, String description, int count, @Nullable FOOD_STATUS foodStatus) {
}
