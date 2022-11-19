package com.shelfy.service;

import com.shelfy.model.recipes.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipesByIngredients(String ingredients);
}
