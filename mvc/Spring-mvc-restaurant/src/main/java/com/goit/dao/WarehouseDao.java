package com.goit.dao;

import com.goit.model.Ingredient;
import com.goit.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    void createWarehouse(Warehouse warehouse);
    Warehouse findWarehouseById(int id);
    List<Warehouse> getAllWarehouse();
    void deleteWarehouse(int id);
    void updateWarehouseIngredientId(int id, Ingredient newWarehouseIngredient);
    void updateWarehouseAmount(int id, float newWarehouseAmount);
}
