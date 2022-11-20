package com.batm.Day2.services;

import com.batm.Day2.entities.Category;
import com.batm.Day2.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean saveCategory(Category category) {
        categoryRepository.save(category);
        return categoryRepository.findById(category.getId()).isPresent();
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category tidak ditemukan"));
    }

    @Override
    public boolean deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
        return !categoryRepository.findById(id).isPresent();
    }
}