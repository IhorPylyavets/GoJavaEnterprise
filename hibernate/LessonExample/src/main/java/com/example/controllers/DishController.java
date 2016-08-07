package com.example.controllers;

import com.example.dao.DishDao;
import com.example.model.Dish;
import com.example.model.DishCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DishController {

    private DishDao dishDao;

    @Transactional
    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(10.0F);
        plov.setWeight(450F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.0F);
        salad.setWeight(300F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(4.0F);
        potato.setWeight(400F);

        Set<Dish> dishSet = new HashSet<>(dishDao.findAll());
        if (!dishSet.contains(plov)) {
            dishDao.save(plov);
        }
        if (!dishSet.contains(salad)) {
            dishDao.save(salad);
        }
        if (!dishSet.contains(potato)) {
            dishDao.save(potato);
        }

    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.findAll();
    }

    @Transactional
    public  Dish getDishByName(String name) {
        return dishDao.findByName(name);
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
