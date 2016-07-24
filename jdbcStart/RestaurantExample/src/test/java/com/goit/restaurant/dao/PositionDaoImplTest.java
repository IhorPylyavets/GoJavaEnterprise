package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionDaoImplTest {

    private PositionDaoImpl positionDao;

    @Before
    public void init() {
        positionDao = new PositionDaoImpl();
    }

    @Test
    public void testCreatePosition() throws Exception {
        String positionTitle = "Test position60905";
        Position createPosition = positionDao.create(positionTitle);
        Position position = positionDao.load(createPosition.getId());
        assertEquals(position.getTitle(), positionTitle);

        positionDao.delete(createPosition.getId());
    }

    @Test
    public void testUpdatePosition() throws Exception {
        String title = "qwerty";
        Position createPosition = positionDao.create(title);

        String newTitle = "newPositionTitle";
        positionDao.update(createPosition.getId(), newTitle);
        Position loadPosition = positionDao.load(createPosition.getId());
        assertEquals(loadPosition.getTitle(), newTitle);

        positionDao.delete(loadPosition.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeletePosition() throws Exception {
        String title = "qwerty";
        Position createPosition = positionDao.create(title);
        positionDao.delete(createPosition.getId());
        Position pos = positionDao.load(createPosition.getId());
    }

    @Test
    public void testPositionReadMetaData() throws Exception {
        String metaData = positionDao.readMetadata();
        System.out.println(metaData);
    }

}