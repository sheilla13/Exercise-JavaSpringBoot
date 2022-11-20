package com.batm.Day2.controllers;

import com.batm.Day2.entities.Category;
import com.batm.Day2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {
    // instance object dari Service
    @Autowired
    private CategoryService categoryService;

    // get all
    @GetMapping
    public String categoryIndex(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        return "category/category-index";
    }

    // form save
    // category/form
    // category/form/1
    @GetMapping(value = {"form", "form/{id}"})
    public String categoryForm(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("category", categoryService.findCategoryById(id));
        } else {
            model.addAttribute("category", new Category());
        }
        return "category/category-form";
    }

    // save
    // category/save
    @PostMapping("save")
    public String categorySave(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/category";
    }

    // delete
    // category/delete/1
    @PostMapping("delete/{id}")
    public String categoryDelete(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }
}