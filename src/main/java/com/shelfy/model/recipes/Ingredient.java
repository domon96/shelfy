package com.shelfy.model.recipes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Ingredient(
        int id,
        double amount,
        String unit,
        String unitShort,
        String name,
        String original,
        String image
) {
}
