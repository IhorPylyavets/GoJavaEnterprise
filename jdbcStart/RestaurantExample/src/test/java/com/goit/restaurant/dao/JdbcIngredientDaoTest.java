package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.IngredientController;
import com.goit.restaurant.model.Ingredient;
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
public class JdbcIngredientDaoTest {

    @Autowired
    private IngredientController ingredientController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteIngredient() throws Exception {
        List<Ingredient> ingredientList = ingredientController.getAllIngredient();
        String testIngredientTitle = "Test ingredient";
        ingredientController.createIngredient(testIngredientTitle);
        List<Ingredient> ingredientListCurrent = ingredientController.getAllIngredient();
        assertEquals(ingredientList.size(), ingredientListCurrent.size()-1);
        assertEquals(ingredientListCurrent.get(ingredientListCurrent.size()-1).getIngredientTitle(), testIngredientTitle);

        ingredientController.deleteIngredient(ingredientListCurrent.get(ingredientListCurrent.size()-1).getId());
        ingredientListCurrent = ingredientController.getAllIngredient();
        assertEquals(ingredientList.size(), ingredientListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindIngredientById() throws Exception {
        String testIngredientTitle = "Test ingredient";
        ingredientController.createIngredient(testIngredientTitle);
        List<Ingredient> ingredientList = ingredientController.getAllIngredient();
        Ingredient ingredient = ingredientController.findIngredientById(ingredientList.get(ingredientList.size()-1).getId());
        assertEquals(ingredient.getIngredientTitle(), testIngredientTitle);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateIngredientTitle() throws Exception {
        String testIngredientTitle = "Test ingredient";
        ingredientController.createIngredient(testIngredientTitle);
        String testUpdateIngredientTitle = "Update Test ingredient";
        List<Ingredient> ingredientList = ingredientController.getAllIngredient();
        ingredientController.updateIngredientTitle(ingredientList.get(ingredientList.size()-1).getId(), testUpdateIngredientTitle);
        Ingredient ingredient = ingredientController.findIngredientById(ingredientList.get(ingredientList.size()-1).getId());
        assertEquals(ingredient.getIngredientTitle(), testUpdateIngredientTitle);
    }

}