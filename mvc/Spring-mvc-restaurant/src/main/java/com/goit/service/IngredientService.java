package com.goit.service;

import com.goit.dao.IngredientDao;
import com.goit.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientService {

    private IngredientDao ingredientDao;

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Transactional
    public void createIngredient(Ingredient ingredient) {
        ingredientDao.createIngredient(ingredient);
    }

    @Transactional
    public List<Ingredient> getAllIngredient() {
        return ingredientDao.getAllIngredient();
    }

    @Transactional
    public Ingredient findIngredientById(int id) {
        return ingredientDao.findIngredientById(id);
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
