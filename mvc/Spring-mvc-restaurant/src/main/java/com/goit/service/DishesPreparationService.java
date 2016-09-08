/*
package com.goit.service;

import com.goit.dao.DishesPreparationDao;
import com.goit.model.Dish;
import com.goit.model.DishesPreparation;
import com.goit.model.Employee;
import com.goit.model.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public class DishesPreparationService {

    private DishesPreparationDao dishesPreparationDao;

    public void setDishesPreparationDao(DishesPreparationDao dishesPreparationDao) {
        this.dishesPreparationDao = dishesPreparationDao;
    }

    @Transactional
    public void createDishesPreparation(DishesPreparation dishesPreparation) {
        dishesPreparationDao.createDishesPreparation(dishesPreparation);
    }

    @Transactional
    public DishesPreparation findDishesPreparationById(int id) {
        return dishesPreparationDao.findDishesPreparationById(id);
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
    public void updateDishesPreparationDish(int id, Dish newDish) {
        dishesPreparationDao.updateDishesPreparationDish(id, newDish);
    }

    @Transactional
    public void updateDishesPreparationCook(int id, Employee newCook) {
        dishesPreparationDao.updateDishesPreparationCook(id, newCook);
    }

    @Transactional
    public void updateDishesPreparationOrder(int id, Orders newOrder) {
        dishesPreparationDao.updateDishesPreparationOrder(id, newOrder);
    }

    @Transactional
    public void updateDishesPreparationDate(int id, Timestamp newDate) {
        dishesPreparationDao.updateDishesPreparationDate(id, newDate);
    }
}
*/
