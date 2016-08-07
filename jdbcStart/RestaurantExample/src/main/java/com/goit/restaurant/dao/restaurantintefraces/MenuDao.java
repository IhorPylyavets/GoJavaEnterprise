package com.goit.restaurant.dao.restaurantintefraces;

import com.goit.restaurant.model.Menu;

import java.util.List;

public interface MenuDao {
    void createMenu(String menuTitle);
    Menu findMenuById(int id);
    List<Menu> getAllMenu();
    void deleteMenu(int id);
    void updateMenuTitle(int id, String newMenuTitle);
    //String readMenuMetadata();
}
