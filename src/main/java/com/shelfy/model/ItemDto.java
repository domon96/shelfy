package com.shelfy.model;

import java.time.Instant;

public record ItemDto(int productId, Instant date, String description, int count) {
}
