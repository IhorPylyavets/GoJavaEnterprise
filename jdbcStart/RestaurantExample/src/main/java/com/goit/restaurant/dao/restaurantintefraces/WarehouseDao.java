package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    void createWarehouse(int ingredientId, int amount);
    Warehouse loadWarehouseById(int id);
    List<Warehouse> getAllWarehouse();
    void deleteWarehouse(int id);
    void updateWarehouseIngredientId(int id, int newWarehouseIngredientId);
    void updateWarehouseAmount(int id, int newWarehouseAmount);
}
