package com.goit.restaurant.dao;

import com.goit.restaurant.model.Ingredient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientDaoImplTest {
    private IngredientDaoImpl ingredientDao;

    @Before
    public void init() {
        ingredientDao = new IngredientDaoImpl();
    }

    @Test
    public void testCreateIngredient() throws Exception {
        String ingredientTitle = "Test ingredient title";
        Ingredient createIngredient = ingredientDao.create(ingredientTitle);
        Ingredient ingredient = ingredientDao.load(createIngredient.getId());
        assertEquals(ingredient.getTitle(), ingredientTitle);

        ingredientDao.delete(createIngredient.getId());
    }

    @Test
    public void testUpdateIngredient() throws Exception {
        String number = "qwerty Ingredient";
        Ingredient createIngredient = ingredientDao.create(number);

        String newTitle = "newIngredientTitle";
        ingredientDao.update(createIngredient.getId(), newTitle);
        Ingredient loadIngredient = ingredientDao.load(createIngredient.getId());
        assertEquals(loadIngredient.getTitle(), newTitle);

        ingredientDao.delete(loadIngredient.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteIngredient() throws Exception {
        String title = "qwerty Ingredient";
        Ingredient createIngredient = ingredientDao.create(title);
        ingredientDao.delete(createIngredient.getId());
        Ingredient ingredient = ingredientDao.load(createIngredient.getId());
    }

    @Test
    public void testIngredientReadMetaData() throws Exception {
        String metaData = ingredientDao.readMetadata();
        System.out.println(metaData);
    }
}