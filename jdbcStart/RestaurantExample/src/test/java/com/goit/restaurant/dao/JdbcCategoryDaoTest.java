package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.CategoryController;
import com.goit.restaurant.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcCategoryDaoTest {

    @Autowired
    private CategoryController categoryController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteCategory() throws Exception {
        List<Category> categoryList = categoryController.getAllCategories();
        String testCategoryTitle = "Test Category";
        categoryController.createCategory(testCategoryTitle);
        List<Category> categoryListCurrent = categoryController.getAllCategories();
        assertEquals(categoryList.size(), categoryListCurrent.size()-1);
        assertEquals(categoryListCurrent.get(categoryListCurrent.size()-1).getCategoryTitle(), testCategoryTitle);

        categoryController.deleteCategory(categoryListCurrent.get(categoryListCurrent.size()-1).getId());
        categoryListCurrent = categoryController.getAllCategories();
        assertEquals(categoryList.size(), categoryListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindCategoryById() throws Exception {
        String testCategoryTitle = "Test Category";
        categoryController.createCategory(testCategoryTitle);
        List<Category> categoryList = categoryController.getAllCategories();
        Category category = categoryController.findCategoryById(categoryList.get(categoryList.size()-1).getId());
        assertEquals(category.getCategoryTitle(), testCategoryTitle);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateCategoryTitle() throws Exception {
        String testCategoryTitle = "Test Category";
        categoryController.createCategory(testCategoryTitle);
        String testUpdateCategoryTitle = "Update Test Category";
        List<Category> categoryList = categoryController.getAllCategories();
        categoryController.updateCategoryTitle(categoryList.get(categoryList.size()-1).getId(), testUpdateCategoryTitle);
        Category category = categoryController.findCategoryById(categoryList.get(categoryList.size()-1).getId());
        assertEquals(category.getCategoryTitle(), testUpdateCategoryTitle);
    }
}