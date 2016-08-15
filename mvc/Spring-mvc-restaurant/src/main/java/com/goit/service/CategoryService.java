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
        categoryDao.createCategory(category);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategory();
    }

    @Transactional
    public Category findCategoryById(int id) {
        return categoryDao.findCategoryById(id);
    }

    @Transactional
    public void deleteCategory(int id) {
        categoryDao.deleteCategory(id);
    }

    @Transactional
    public void updateCategoryTitle(int id, String newCategoryTitle) {
        categoryDao.updateCategoryTitle(id, newCategoryTitle);
    }
}
