package com.goit.service;

import com.goit.dao.CategoryDao;
import com.goit.model.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao;

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional
    public void createCategory(Category category) {
        categoryDao.create(category);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @Transactional
    public Category findCategoryById(int id) {
        return categoryDao.findById(id);
    }

    @Transactional
    public Category findCategoryByTitle(String categoryTitle) {
        return categoryDao.findByTitle(categoryTitle);
    }

    @Transactional
    public void deleteCategory(int id) {
        categoryDao.delete(id);
    }

    @Transactional
    public void updateCategoryTitle(int id, String newCategoryTitle) {
        categoryDao.updateTitle(id, newCategoryTitle);
    }
}
