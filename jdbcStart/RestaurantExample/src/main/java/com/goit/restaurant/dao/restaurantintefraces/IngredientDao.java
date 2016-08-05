package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    void createIngredient(String ingredientTitle);
    Ingredient findIngredientById(int id);
    List<Ingredient> getAllIngredient();
    void deleteIngredient(int id);
    void updateIngredientTitle(int id, String newIngredientTitle);
}
