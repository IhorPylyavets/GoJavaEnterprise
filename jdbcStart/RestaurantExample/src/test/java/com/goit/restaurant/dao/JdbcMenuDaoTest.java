package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.MenuController;
import com.goit.restaurant.model.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcMenuDaoTest {

    @Autowired
    private MenuController menuController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteMenu() throws Exception {
        List<Menu> menuList = menuController.getAllMenu();
        String testMenuTitle = "Test Menu Title";
        menuController.createMenu(testMenuTitle);
        List<Menu> menuListCurrent = menuController.getAllMenu();
        assertEquals(menuList.size(), menuListCurrent.size()-1);
        assertEquals(menuListCurrent.get(menuListCurrent.size()-1).getMenuTitle(), testMenuTitle);

        menuController.deleteMenu(menuListCurrent.get(menuListCurrent.size()-1).getId());
        menuListCurrent = menuController.getAllMenu();
        assertEquals(menuList.size(), menuListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindMenuById() throws Exception {
        String testMenuTitle = "Test Menu Title";
        menuController.createMenu(testMenuTitle);
        List<Menu> menuList = menuController.getAllMenu();
        Menu menu = menuController.findMenuById(menuList.get(menuList.size()-1).getId());
        assertEquals(menu.getMenuTitle(), testMenuTitle);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateMenuTitle() throws Exception {
        String testMenuTitle = "Test Menu Title";
        menuController.createMenu(testMenuTitle);
        String testUpdateMenuTitle = "Update Test Menu";
        List<Menu> menuList = menuController.getAllMenu();
        menuController.updateMenuTitle(menuList.get(menuList.size()-1).getId(), testUpdateMenuTitle);
        Menu menu = menuController.findMenuById(menuList.get(menuList.size()-1).getId());
        assertEquals(menu.getMenuTitle(), testUpdateMenuTitle);
    }

}