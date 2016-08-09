package com.goit.restaurant.dao;

import com.goit.restaurant.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void createIngredient(Ingredient ingredient);
    Ingredient findIngredientById(int id);
    List<Ingredient> getAllIngredient();
    void deleteIngredient(int id);
    void updateIngredientTitle(int id, String newIngredientTitle);
}
