package com.shelfy.controller;

import com.shelfy.model.Category;
import com.shelfy.model.CategoryDto;
import com.shelfy.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/getCategories")
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @RequestMapping("/addCategory")
    @PostMapping
    public Category addCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto.name());
    }
}
