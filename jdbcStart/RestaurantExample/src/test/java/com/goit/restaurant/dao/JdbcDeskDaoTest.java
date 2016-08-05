package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.DeskController;
import com.goit.restaurant.model.Desk;
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
public class JdbcDeskDaoTest {

    @Autowired
    private DeskController deskController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeletePosition() throws Exception {
        List<Desk> deskList = deskController.getAllDesks();
        String testDeskTitle = "Test Desk Title";
        deskController.createDesk(testDeskTitle);
        List<Desk> deskListCurrent = deskController.getAllDesks();
        assertEquals(deskList.size(), deskListCurrent.size()-1);
        assertEquals(deskListCurrent.get(deskListCurrent.size()-1).getDeskTitle(), testDeskTitle);

        deskController.deleteDesk(deskListCurrent.get(deskListCurrent.size()-1).getId());
        deskListCurrent = deskController.getAllDesks();
        assertEquals(deskList.size(), deskListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindPositionById() throws Exception {
        String testDeskTitle = "Test Desk Title";
        deskController.createDesk(testDeskTitle);
        List<Desk> deskList = deskController.getAllDesks();
        Desk desk = deskController.findDeskById(deskList.get(deskList.size()-1).getId());
        assertEquals(desk.getDeskTitle(), testDeskTitle);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdatePositionTitle() throws Exception {
        String testDeskTitle = "Test Desk Title";
        deskController.createDesk(testDeskTitle);
        String testUpdateDeskTitle = "Update Test Desk";
        List<Desk> deskList = deskController.getAllDesks();
        deskController.updateDeskTitle(deskList.get(deskList.size()-1).getId(), testUpdateDeskTitle);
        Desk desk = deskController.findDeskById(deskList.get(deskList.size()-1).getId());
        assertEquals(desk.getDeskTitle(), testUpdateDeskTitle);
    }

}