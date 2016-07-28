package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.CategoryDao;
import com.goit.restaurant.model.Category;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CategoryController {

    private PlatformTransactionManager txManager;
    private CategoryDao categoryDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional
    public void createCategory(String categoryTitle) {
        categoryDao.createCategory(categoryTitle);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategory();
    }

    @Transactional
    public Category loadCategoryById(int id) {
        return categoryDao.loadCategoryById(id);
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
