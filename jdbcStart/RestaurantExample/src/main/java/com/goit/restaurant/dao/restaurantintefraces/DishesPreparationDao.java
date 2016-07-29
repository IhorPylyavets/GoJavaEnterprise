package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.DishesPreparation;

import java.util.List;

public interface DishesPreparationDao {
    void createDishesPreparation(int dishesId, int employeeId, int orderId, String date);
    DishesPreparation loadDishesPreparationById(int id);
    List<DishesPreparation> getAllDishesPreparation();
    void deleteDishesPreparation(int id);
    void updateDishesPreparationEmployeeId(int id, int newDishesPreparationEmployeeId);
    void updateDishesPreparationDishesId(int id, int newDishesPreparationDishesId);
    void updateDishesPreparationOrderId(int id, int newDishesPreparationOrderId);
    void updateDishesPreparationDate(int id, String newDishesPreparationDate);
}
