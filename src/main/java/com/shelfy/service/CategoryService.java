package com.shelfy.service;

import com.shelfy.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category addCategory(String nameOfCategory);
}
