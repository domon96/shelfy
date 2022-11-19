package com.shelfy.controller;

import com.shelfy.model.recipes.Recipe;
import com.shelfy.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getRecipesByIngredients/{ingredients}")
    public List<Recipe> getRecipes(@PathVariable String ingredients) {
        return recipeService.getRecipesByIngredients(ingredients);
    }
}
