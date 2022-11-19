package com.shelfy.model;

import java.time.LocalDate;

public record ItemDto(int productId, LocalDate date, String description, int count) {
}
