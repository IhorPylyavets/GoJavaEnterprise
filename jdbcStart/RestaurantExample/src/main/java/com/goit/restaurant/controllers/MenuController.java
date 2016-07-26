package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.MenuDao;
import com.goit.restaurant.model.Menu;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional(propagation = Propagation.REQUIRED)
    public Menu createMenu(String menuTitle) {
        return menuDao.createMenu(menuTitle);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Menu> getAllMenu() {
        return menuDao.getAllMenu();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Menu loadMenuById(int id) {
        return menuDao.loadMenuById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMenu(int id) {
        menuDao.deleteMenu(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMenu(int id, String newMenuTitle) {
        menuDao.updateMenu(id, newMenuTitle);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String readMenuMetadata() {
        return menuDao.readMenuMetadata();
    }
}
