package com.goit.service;

import com.goit.dao.MenuDao;
import com.goit.model.Dish;
import com.goit.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuService {

    private MenuDao menuDao;

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public void createMenu(Menu menu) {
        menuDao.createMenu(menu);
    }

    @Transactional
    public Menu findMenuById(int id) {
        return menuDao.findMenuById(id);
    }

    @Transactional
    public Menu findMenuByTitle(String menuTitle) {
        return menuDao.findMenuByTitle(menuTitle);
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Transactional
    public void deleteMenu(int id) {
        menuDao.deleteMenu(id);
    }

    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        menuDao.updateMenuTitle(id, newMenuTitle);
    }

    @Transactional
    public List<Dish> getAllDishByMenuId(int id) {
        return menuDao.getAllDishByMenuId(id);
    }

    @Transactional
    public void updateMenuDishes(int id, List<Dish> newDishes) {
        menuDao.updateMenuDishes(id, newDishes);
    }
}
