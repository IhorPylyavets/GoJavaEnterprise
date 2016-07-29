package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.DishesPreparationDao;
import com.goit.restaurant.model.DishesPreparation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishesPreparationController {

    private PlatformTransactionManager txManager;
    private DishesPreparationDao dishesPreparationDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDishesPreparationDao(DishesPreparationDao dishesPreparationDao) {
        this.dishesPreparationDao = dishesPreparationDao;
    }

    @Transactional
    public void createDishesPreparation(int dishesId, int employeeId, int orderId, String date) {
        dishesPreparationDao.createDishesPreparation(dishesId, employeeId, orderId, date);
    }

    @Transactional
    public DishesPreparation loadDishesPreparationById(int id) {
        return dishesPreparationDao.loadDishesPreparationById(id);
    }

    @Transactional
    public List<DishesPreparation> getAllDishesPreparation() {
        return dishesPreparationDao.getAllDishesPreparation();
    }

    @Transactional
    public void deleteDishesPreparation(int id) {
        dishesPreparationDao.deleteDishesPreparation(id);
    }

    @Transactional
    public void updateDishesPreparationDishesId(int id, int newDishesPreparationDishesId) {
        dishesPreparationDao.updateDishesPreparationDishesId(id, newDishesPreparationDishesId);
    }

    @Transactional
    public void updateDishesPreparationEmployeeId(int id, int newDishesPreparationEmployeeId) {
        dishesPreparationDao.updateDishesPreparationEmployeeId(id, newDishesPreparationEmployeeId);
    }

    @Transactional
    public void updateDishesPreparationOrderId(int id, int newDishesPreparationOrderId) {
        dishesPreparationDao.updateDishesPreparationOrderId(id, newDishesPreparationOrderId);
    }

    @Transactional
    public void updateDishesPreparationDate(int id, String newDishesPreparationDate) {
        dishesPreparationDao.updateDishesPreparationDate(id, newDishesPreparationDate);
    }
}
