package com.shelfy.controller;

import com.shelfy.model.Category;
import com.shelfy.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/getCategories")
    @GetMapping
    public List<Category> getProducts() {
        return categoryService.getCategories();
    }

    @RequestMapping("/addCategory/{name}")
    @GetMapping
    public Category addCategory(@PathVariable String name) {
        return categoryService.addCategory(name);
    }
}
