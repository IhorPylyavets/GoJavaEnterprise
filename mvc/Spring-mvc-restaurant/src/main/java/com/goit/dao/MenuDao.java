package com.goit.dao;

import com.goit.model.Dish;
import com.goit.model.Menu;

import java.util.List;

public interface MenuDao {

    void createMenu(Menu menu);

    Menu findMenuById(int id);

    Menu findMenuByTitle(String menuTitle);

    List<Menu> getAllMenu();

    void deleteMenu(int id);

    void updateMenuTitle(int id, String newMenuTitle);

    List<Dish> getAllDishByMenuId(int id);

    void updateMenuDishes(int id, List<Dish> newDishes);

}
