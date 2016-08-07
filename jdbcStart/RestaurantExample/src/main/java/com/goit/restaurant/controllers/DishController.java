package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.DishDao;
import com.goit.restaurant.model.Dish;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishController {

    private PlatformTransactionManager txManager;
    private DishDao dishDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public void createDish(String dishTitle, int categoryId, float price, float weight) {
        dishDao.createDish(dishTitle, categoryId, price, weight);
    }

    @Transactional
    public Dish findDishById(int id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public List<Dish> getAllDish() {
        return dishDao.getAllDish();
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
    public void updateDishCategoryId(int id, int newDishCategoryId) {
        dishDao.updateDishCategoryId(id, newDishCategoryId);
    }

    @Transactional
    public void updateDishPrice(int id, float newDishPrice) {
        dishDao.updateDishPrice(id, newDishPrice);
    }

    @Transactional
    public void updateDishWeight(int id, float newDishWeight) {
        dishDao.updateDishWeight(id, newDishWeight);
    }

}
