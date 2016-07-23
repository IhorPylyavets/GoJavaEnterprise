package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeskDaoImplTest {

    private DeskDao deskDao;

    @Before
    public void init() {
        deskDao = new DeskDaoImpl();
    }

    @Test
    public void testCreateDesk() throws Exception {
        String deskNumber = "Test desk number";
        Desk createDesk = deskDao.createDesk(deskNumber);
        Desk desk = deskDao.loadDesk(createDesk.getId());
        assertEquals(desk.getNumber(), deskNumber);

        deskDao.deleteDesk(createDesk.getId());
    }

    @Test
    public void testUpdateDesk() throws Exception {
        String number = "qwerty desk";
        Desk createDesk = deskDao.createDesk(number);

        String newNumber = "newDeskNumber";
        deskDao.updateDesk(createDesk.getId(), newNumber);
        Desk loadDesk = deskDao.loadDesk(createDesk.getId());
        assertEquals(loadDesk.getNumber(), newNumber);

        deskDao.deleteDesk(loadDesk.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteDesk() throws Exception {
        String number = "qwerty desk";
        Desk createDesk = deskDao.createDesk(number);
        deskDao.deleteDesk(createDesk.getId());
        Desk desk = deskDao.loadDesk(createDesk.getId());
    }

    @Test
    public void testDeskReadMetaData() throws Exception {
        String metaData = deskDao.readMetadata();
        System.out.println(metaData);
    }


}