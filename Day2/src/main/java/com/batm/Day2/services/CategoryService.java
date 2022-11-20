package com.batm.Day2.services;

import com.batm.Day2.entities.Category;

import java.util.List;

public interface CategoryService {
    public boolean saveCategory(Category category);
    public List<Category> findAllCategories();
    public Category findCategoryById(int id);
    public boolean deleteCategoryById(int id);
}