package com.goit.restaurant.dao;

import com.goit.restaurant.model.Category;

import java.util.List;

public interface CategoryDao {
    void createCategory(Category category);
    Category findCategoryById(int id);
    List<Category> getAllCategory();
    void deleteCategory(int id);
    void updateCategoryTitle(int id, String newCategoryTitle);
}
