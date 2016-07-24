package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeskDaoImplTest {

    private DeskDaoImpl deskDao;

    @Before
    public void init() {
        deskDao = new DeskDaoImpl();
    }

    @Test
    public void testCreateDesk() throws Exception {
        String deskNumber = "Test desk number";
        Desk createDesk = deskDao.create(deskNumber);
        Desk desk = deskDao.load(createDesk.getId());
        assertEquals(desk.getNumber(), deskNumber);

        deskDao.delete(createDesk.getId());
    }

    @Test
    public void testUpdateDesk() throws Exception {
        String number = "qwerty desk";
        Desk createDesk = deskDao.create(number);

        String newNumber = "newDeskNumber";
        deskDao.update(createDesk.getId(), newNumber);
        Desk loadDesk = deskDao.load(createDesk.getId());
        assertEquals(loadDesk.getNumber(), newNumber);

        deskDao.delete(loadDesk.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteDesk() throws Exception {
        String number = "qwerty desk";
        Desk createDesk = deskDao.create(number);
        deskDao.delete(createDesk.getId());
        Desk desk = deskDao.load(createDesk.getId());
    }

    @Test
    public void testDeskReadMetaData() throws Exception {
        String metaData = deskDao.readMetadata();
        System.out.println(metaData);
    }

}