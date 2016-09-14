package com.goit.dao;

import com.goit.model.Category;
import com.goit.model.Dish;
import com.goit.model.Ingredient;

import java.util.List;

public interface DishDao {
    void createDish(Dish dish);
    Dish findDishById(int id);
    Dish findDishByTitle(String dishTitle);
    List<Dish> getAllDish();
    List<Ingredient> getAllIngredientByDishId(int id);
    void deleteDish(int id);
    void updateDishTitle(int id, String newDishTitle);
    void updateDishCategoryId(int id, Category newCategory);
    void updateDishPrice(int id, float newDishPrice);
    void updateDishWeight(int id, float newDishWeight);
    void updateDistIngredients(int id, List<Ingredient> newIngredients);
}
