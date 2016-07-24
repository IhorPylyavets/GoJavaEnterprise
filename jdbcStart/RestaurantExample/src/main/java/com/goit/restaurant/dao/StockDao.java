package com.goit.restaurant.dao;

import com.goit.restaurant.model.Stock;

import java.util.List;

public interface StockDao {
    Stock create(int ingredientId, int amount);
    Stock load(int id);
    List<Stock> getAll();
    void delete(int id);
    //void updateEmployee(int id, String newPositionTitle);
    String readMetadata();
}
