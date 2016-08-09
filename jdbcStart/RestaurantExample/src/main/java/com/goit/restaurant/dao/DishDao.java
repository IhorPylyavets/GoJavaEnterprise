package com.goit.restaurant.dao;

import com.goit.restaurant.model.Dish;

import java.util.List;

public interface DishDao {
    void createDish(String dishTitle, int categoryId, float price, float weight);
    Dish findDishById(int id);
    List<Dish> getAllDish();
    void deleteDish(int id);
    void updateDishTitle(int id, String newDishTitle);
    void updateDishCategoryId(int id, int newDishCategoryId);
    void updateDishPrice(int id, float newDishPrice);
    void updateDishWeight(int id, float newDishWeight);
}
