package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JdbcPositionDaoTest {

    private JdbcPositionDao positionDao;

    @Before
    public void init() {
        positionDao = new JdbcPositionDao();
    }

    @Test
    public void testCreatePosition() throws Exception {
        String positionTitle = "Test position60905";
        Position createPosition = positionDao.createPosition(positionTitle);
        Position position = positionDao.loadPosition(createPosition.getId());
        assertEquals(position.getTitle(), positionTitle);

        positionDao.deletePosition(createPosition.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        String title = "qwerty";
        Position createPosition = positionDao.createPosition(title);

        String newTitle = "newPositionTitle";
        positionDao.updatePosition(createPosition.getId(), newTitle);
        Position loadPosition = positionDao.loadPosition(createPosition.getId());
        assertEquals(loadPosition.getTitle(), newTitle);

        positionDao.deletePosition(loadPosition.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDelete() throws Exception {
        String title = "qwerty";
        Position createPosition = positionDao.createPosition(title);
        positionDao.deletePosition(createPosition.getId());
        Position pos = positionDao.loadPosition(createPosition.getId());
    }

    @Test
    public void testReadMetaData() throws Exception {
        String metaData = positionDao.readMetadata();
        System.out.println(metaData);
    }

}