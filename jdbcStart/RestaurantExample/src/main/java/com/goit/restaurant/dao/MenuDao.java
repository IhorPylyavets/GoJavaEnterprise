package com.goit.restaurant.dao;

import com.goit.restaurant.model.Menu;

import java.util.List;

public interface MenuDao {
    Menu createMenu(String menuTitle);
    Menu loadMenuById(int id);
    List<Menu> getAllMenu();
    void deleteMenu(int id);
    void updateMenu(int id, String newMenuTitle);
    String readMenuMetadata();
}
