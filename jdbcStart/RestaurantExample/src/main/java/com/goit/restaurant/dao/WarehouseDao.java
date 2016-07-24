package com.goit.restaurant.dao;

import com.goit.restaurant.model.Warehouse;

import java.util.List;

public interface WarehouseDao {
    Warehouse create(int ingredientId, int amount);
    Warehouse load(int id);
    List<Warehouse> getAll();
    void delete(int id);
    //void updateEmployee(int id, String newPositionTitle);
    String readMetadata();
}
