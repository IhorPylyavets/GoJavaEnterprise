package com.goit;

import com.goit.dao.DishDao;
import com.goit.dao.IngredientDao;
import com.goit.model.Dish;
import com.goit.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDB {

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private DishDao dishDao;

    @PostConstruct
    public void init() {
        List<Ingredient> olivieIngredients = new ArrayList<>();
        olivieIngredients.add(ingredientDao.findByTitle("potato"));
        olivieIngredients.add(ingredientDao.findByTitle("eggs"));

        Dish olivie = dishDao.findDishByTitle("Olivie");
        System.out.println(olivie);
        olivie.setIngredients(olivieIngredients);
    }

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
