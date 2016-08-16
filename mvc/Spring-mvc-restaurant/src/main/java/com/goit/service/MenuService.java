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
        menuDao.create(menu);
    }

    @Transactional
    public List<Menu> getAllMenu() {
        return menuDao.getAll();
    }

    @Transactional
    public Menu findMenuById(int id) {
        return menuDao.findById(id);
    }

    @Transactional
    public Menu findMenuByTitle(String menuTitle) {
        return menuDao.findByTitle(menuTitle);
    }

    @Transactional
    public void deleteMenu(int id) {
        menuDao.delete(id);
    }

    @Transactional
    public void updateMenuTitle(int id, String newMenuTitle) {
        menuDao.updateTitle(id, newMenuTitle);
    }
}
