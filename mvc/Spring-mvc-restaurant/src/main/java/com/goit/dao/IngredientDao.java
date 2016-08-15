package com.goit.dao;

import com.goit.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void createIngredient(Ingredient ingredient);
    Ingredient findIngredientById(int id);
    List<Ingredient> getAllIngredient();
    void deleteIngredient(int id);
    void updateIngredientTitle(int id, String newIngredientTitle);
}
