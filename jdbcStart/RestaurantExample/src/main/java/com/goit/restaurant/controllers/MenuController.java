package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.restaurantintefraces.MenuDao;
import com.goit.restaurant.model.Menu;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MenuController {
    private PlatformTransactionManager txManager;
    private MenuDao menuDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public void createMenu(String menuTitle) {
        menuDao.createMenu(menuTitle);
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Transactional
    public Menu findMenuById(int id) {
        return menuDao.findMenuById(id);
    }

    @Transactional
    public void deleteMenu(int id) {
        menuDao.deleteMenu(id);
    }

    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        menuDao.updateMenuTitle(id, newMenuTitle);
    }

}
