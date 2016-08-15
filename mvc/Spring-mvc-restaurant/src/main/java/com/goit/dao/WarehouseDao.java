package com.goit.dao;

import com.goit.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    void createWarehouse(Warehouse warehouse);
    Warehouse findWarehouseById(int id);
    List<Warehouse> getAllWarehouse();
    void deleteWarehouse(int id);
    void updateWarehouseIngredientId(int id, int newWarehouseIngredientId);
    void updateWarehouseAmount(int id, float newWarehouseAmount);
}
