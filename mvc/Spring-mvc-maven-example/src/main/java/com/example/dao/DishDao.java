package com.example.dao;

import com.example.model.Dish;

import java.util.List;

public interface DishDao {

    void save(Dish dish);

    List<Dish> findAll();

    Dish findByName(String name);

}
