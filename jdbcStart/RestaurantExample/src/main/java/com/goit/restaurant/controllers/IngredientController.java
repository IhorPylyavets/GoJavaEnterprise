package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.IngredientDao;
import com.goit.restaurant.model.Ingredient;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientController {

    private PlatformTransactionManager txManager;
    private IngredientDao ingredientDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Transactional
    public void createIngredient(String ingredientTitle) {
        ingredientDao.createIngredient(ingredientTitle);
    }

    @Transactional
    public List<Ingredient> getAllIngredient() {
        return ingredientDao.getAllIngredient();
    }

    @Transactional
    public Ingredient loadIngredientById(int id) {
        return ingredientDao.loadIngredientById(id);
    }

    @Transactional
    public void deleteIngredient(int id) {
        ingredientDao.deleteIngredient(id);
    }

    @Transactional
    public void updateIngredientTitle(int id, String newIngredientTitle) {
        ingredientDao.updateIngredientTitle(id, newIngredientTitle);
    }
}
