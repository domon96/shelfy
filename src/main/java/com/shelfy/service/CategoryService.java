package com.shelfy.service;

import com.shelfy.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    Optional<Category> getCategoryById(int id);

    Category addCategory(String nameOfCategory);
}
