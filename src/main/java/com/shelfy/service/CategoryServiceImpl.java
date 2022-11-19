package com.shelfy.service;

import com.shelfy.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public List<Category> getCategories() {
        return List.of();
    }

    @Override
    public Category addCategory(String nameOfCategory) {
        return null;
    }
}
