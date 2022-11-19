package com.shelfy.controller;

import com.shelfy.model.recipes.Recipe;
import com.shelfy.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getRecipesByIngredients")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes(String ingredients) {
        return recipeService.getRecipesByIngredients(ingredients);
    }
}
