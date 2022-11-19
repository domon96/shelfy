package com.shelfy.model.recipes;

import java.util.List;

public record Recipe(
        int id,
        String title,
        String image,
        String imageType,
        int usedIngredientCount,
        List<Ingredient> missedIngredients,
        List<Ingredient> usedIngredients,
        List<Ingredient> unusedIngredients,
        int likes
) {
}
