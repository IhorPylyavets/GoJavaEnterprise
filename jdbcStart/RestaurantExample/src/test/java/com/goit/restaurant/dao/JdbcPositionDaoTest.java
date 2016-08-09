package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.PositionController;
import com.goit.restaurant.model.Position;
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
public class JdbcPositionDaoTest {

    @Autowired
    private PositionController positionController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeletePosition() throws Exception {
        List<Position> positionList = positionController.getAllPosition();

        String testPositionTitle = "Test position";
        Position position = new Position();
        position.setPositionTitle(testPositionTitle);

        positionController.createPosition(position);
        List<Position> positionListCurrent = positionController.getAllPosition();
        assertEquals(positionList.size(), positionListCurrent.size()-1);
        assertEquals(positionListCurrent.get(positionListCurrent.size()-1).getPositionTitle(), testPositionTitle);

        positionController.deletePosition(positionListCurrent.get(positionListCurrent.size()-1).getId());
        positionListCurrent = positionController.getAllPosition();
        assertEquals(positionList.size(), positionListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindPositionById() throws Exception {
        String testPositionTitle = "Test position";
        Position position = new Position();
        position.setPositionTitle(testPositionTitle);

        positionController.createPosition(position);
        List<Position> positionList = positionController.getAllPosition();
        Position positionCurrent = positionController.findPositionById(positionList.get(positionList.size()-1).getId());
        assertEquals(positionCurrent.getPositionTitle(), testPositionTitle);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdatePositionTitle() throws Exception {
        String testPositionTitle = "Test position";
        Position position = new Position();
        position.setPositionTitle(testPositionTitle);

        positionController.createPosition(position);
        String testUpdatePositionTitle = "Update Test position";
        List<Position> positionList = positionController.getAllPosition();
        positionController.updatePositionTitle(positionList.get(positionList.size()-1).getId(), testUpdatePositionTitle);
        Position positionCurrent = positionController.findPositionById(positionList.get(positionList.size()-1).getId());
        assertEquals(positionCurrent.getPositionTitle(), testUpdatePositionTitle);
    }

}