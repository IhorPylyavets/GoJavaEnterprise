package com.goit.service;

import com.goit.dao.MenuDao;
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
