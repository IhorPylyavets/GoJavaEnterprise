package com.goit.service;

import com.goit.dao.DishDao;
import com.goit.model.Category;
import com.goit.model.Dish;
import com.goit.model.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishService {

    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void createDish(Dish dish) {
        dishDao.createDish(dish);
    }

    @Transactional
    public Dish findDishById(int id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public Dish findDishByTitle(String dishTitle) {
        return dishDao.findDishByTitle(dishTitle);
    }

    @Transactional
    public List<Dish> getAllDish() {
        return dishDao.getAllDish();
    }

    @Transactional
    public List<Ingredient> getAllIngredientsByDishId(int id) {
        return dishDao.getAllIngredientByDishId(id);
    }

    @Transactional
    public void deleteDish(int id) {
        dishDao.deleteDish(id);
    }

    @Transactional
    public void updateDishTitle(int id, String newDishTitle) {
        dishDao.updateDishTitle(id, newDishTitle);
    }

    @Transactional
    public void updateDishCategoryId(int id, Category newCategory) {
        dishDao.updateDishCategoryId(id, newCategory);
    }

    @Transactional
    public void updateDishPrice(int id, float newDishPrice) {
        dishDao.updateDishPrice(id, newDishPrice);
    }

    @Transactional
    public void updateDishWeight(int id, float newDishWeight) {
        dishDao.updateDishWeight(id, newDishWeight);
    }

    @Transactional
    public void updateDistIngredients(int id, List<Ingredient> newIngredients) {
        dishDao.updateDistIngredients(id, newIngredients);
    }

}
