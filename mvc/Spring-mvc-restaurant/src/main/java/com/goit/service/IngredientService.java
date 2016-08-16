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
        ingredientDao.create(ingredient);
    }

    @Transactional
    public List<Ingredient> getAllIngredient() {
        return ingredientDao.getAll();
    }

    @Transactional
    public Ingredient findIngredientById(int id) {
        return ingredientDao.findById(id);
    }

    @Transactional
    public Ingredient findIngredientByTitle(String ingredientTitle) {
        return ingredientDao.findByTitle(ingredientTitle);
    }

    @Transactional
    public void deleteIngredient(int id) {
        ingredientDao.delete(id);
    }

    @Transactional
    public void updateIngredientTitle(int id, String newIngredientTitle) {
        ingredientDao.updateTitle(id, newIngredientTitle);
    }
}
