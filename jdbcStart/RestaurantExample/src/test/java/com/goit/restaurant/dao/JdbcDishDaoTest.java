package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.DishController;
import com.goit.restaurant.model.Dish;
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
public class JdbcDishDaoTest {

    @Autowired
    private DishController dishController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteDish() throws Exception {
        List<Dish> dishList = dishController.getAllDish();

        String testDishTitle = "Test Dish title";
        int testCategoryId = 1;
        float testPrice = 23.9F;
        float testWeight = 680.0F;

        dishController.createDish(testDishTitle, testCategoryId, testPrice, testWeight);
        List<Dish> dishListCurrent = dishController.getAllDish();
        assertEquals(dishList.size(), dishListCurrent.size()-1);
        assertEquals(dishListCurrent.get(dishListCurrent.size()-1).getDishTitle(), testDishTitle);
        assertEquals(dishListCurrent.get(dishListCurrent.size()-1).getCategoryId(), testCategoryId);
        assertEquals(dishListCurrent.get(dishListCurrent.size()-1).getPrice(), testPrice, 0.01);
        assertEquals(dishListCurrent.get(dishListCurrent.size()-1).getWeight(), testWeight, 0.01);

        dishController.deleteDish(dishListCurrent.get(dishListCurrent.size()-1).getId());
        dishListCurrent = dishController.getAllDish();
        assertEquals(dishList.size(), dishListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindDishById() throws Exception {
        String testDishTitle = "Test Dish title";
        int testCategoryId = 1;
        float testPrice = 23.9F;
        float testWeight = 680.0F;
        dishController.createDish(testDishTitle, testCategoryId, testPrice, testWeight);
        List<Dish> dishList = dishController.getAllDish();
        Dish dish = dishController.findDishById(dishList.get(dishList.size()-1).getId());
        assertEquals(dish.getDishTitle(), testDishTitle);
        assertEquals(dish.getCategoryId(), testCategoryId);
        assertEquals(dish.getPrice(), testPrice, 0.01);
        assertEquals(dish.getWeight(), testWeight, 0.01);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateDishTitle() throws Exception {
        String testDishTitle = "Test Dish title";
        int testCategoryId = 1;
        float testPrice = 23.9F;
        float testWeight = 680.0F;

        dishController.createDish(testDishTitle, testCategoryId, testPrice, testWeight);
        String testUpdateDishTitle = "Test Update Dish title";
        int testUpdateCategoryId = 2;
        float testUpdateDishPrice = 21.8F;
        float testUpdateDishWeight = 610.0F;
        List<Dish> dishList = dishController.getAllDish();
        dishController.updateDishTitle(dishList.get(dishList.size()-1).getId(), testUpdateDishTitle);
        dishController.updateDishCategoryId(dishList.get(dishList.size()-1).getId(), testUpdateCategoryId);
        dishController.updateDishPrice(dishList.get(dishList.size()-1).getId(), testUpdateDishPrice);
        dishController.updateDishWeight(dishList.get(dishList.size()-1).getId(), testUpdateDishWeight);
    }

}