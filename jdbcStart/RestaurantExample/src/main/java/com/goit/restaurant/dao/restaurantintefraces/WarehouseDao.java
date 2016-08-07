package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    void createWarehouse(int ingredientId, float amount);
    Warehouse findWarehouseById(int id);
    List<Warehouse> getAllWarehouse();
    void deleteWarehouse(int id);
    void updateWarehouseIngredientId(int id, int newWarehouseIngredientId);
    void updateWarehouseAmount(int id, float newWarehouseAmount);
}
