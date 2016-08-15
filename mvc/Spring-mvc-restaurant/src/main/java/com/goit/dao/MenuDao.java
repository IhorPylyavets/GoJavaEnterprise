package com.goit.dao;

import com.goit.model.Menu;

import java.util.List;

public interface MenuDao {
    void createMenu(Menu menu);
    Menu findMenuById(int id);
    List<Menu> getAllMenu();
    void deleteMenu(int id);
    void updateMenuTitle(int id, String newMenuTitle);
}
