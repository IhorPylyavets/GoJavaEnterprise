package com.goit.restaurant.dao;

import com.goit.restaurant.Common;
import com.goit.restaurant.controllers.DishesPreparationController;
import com.goit.restaurant.model.DishesPreparation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcDishesPreparationDaoTest {

    @Autowired
    private DishesPreparationController dishesPreparationController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteDishesPreparation() throws Exception {
        List<DishesPreparation> dishesPreparations = dishesPreparationController.getAllDishesPreparation();
        int testDishesId = 1;
        int testEmployeeId = 1;
        int testOrderId = 1;
        Timestamp testDate = Common.stringToTimestamp("2009-02-21 11:12:17.0");
        dishesPreparationController.createDishesPreparation(testDishesId, testEmployeeId, testOrderId, testDate);
        List<DishesPreparation> dishesPreparationsListCurrent = dishesPreparationController.getAllDishesPreparation();
        assertEquals(dishesPreparations.size(), dishesPreparationsListCurrent.size()-1);
        assertEquals(dishesPreparationsListCurrent.get(dishesPreparationsListCurrent.size()-1).getDishesId(), testDishesId);
        assertEquals(dishesPreparationsListCurrent.get(dishesPreparationsListCurrent.size()-1).getEmployeeId(), testEmployeeId);
        assertEquals(dishesPreparationsListCurrent.get(dishesPreparationsListCurrent.size()-1).getOrderId(), testOrderId);
        assertEquals(dishesPreparationsListCurrent.get(dishesPreparationsListCurrent.size()-1).getDate(), testDate);

        dishesPreparationController.deleteDishesPreparation(dishesPreparationsListCurrent.get(dishesPreparationsListCurrent.size()-1).getId());
        dishesPreparationsListCurrent = dishesPreparationController.getAllDishesPreparation();
        assertEquals(dishesPreparations.size(), dishesPreparationsListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindDishesPreparationById() throws Exception {
        int testDishesId = 1;
        int testEmployeeId = 1;
        int testOrderId = 1;
        Timestamp testDate = Common.stringToTimestamp("2009-02-21 11:12:17.0");
        dishesPreparationController.createDishesPreparation(testDishesId, testEmployeeId, testOrderId, testDate);

        List<DishesPreparation> dishesPreparationList = dishesPreparationController.getAllDishesPreparation();
        DishesPreparation dishesPreparation = dishesPreparationController
                .findDishesPreparationById(dishesPreparationList.get(dishesPreparationList.size()-1).getId());
        assertEquals(dishesPreparation.getDishesId(), testDishesId);
        assertEquals(dishesPreparation.getEmployeeId(), testEmployeeId);
        assertEquals(dishesPreparation.getOrderId(), testOrderId);
        assertEquals(dishesPreparation.getDate(), testDate);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateDishesPreparation() throws Exception {
        int testDishesId = 1;
        int testEmployeeId = 1;
        int testOrderId = 1;
        Timestamp testDate = Common.stringToTimestamp("2009-02-21 11:12:17.0");
        dishesPreparationController.createDishesPreparation(testDishesId, testEmployeeId, testOrderId, testDate);

        List<DishesPreparation> dishesPreparationList = dishesPreparationController.getAllDishesPreparation();
        int testUpdateDishesId = 2;
        int testUpdateEmployeeId = 2;
        int testUpdateOrderId = 2;
        Timestamp testUpdateOrderDate = Common.stringToTimestamp("2013-01-14 12:23:19.0");
        dishesPreparationController.updateDishesPreparationDishesId(
                dishesPreparationList.get(dishesPreparationList.size()-1).getId(), testUpdateDishesId);
        dishesPreparationController.updateDishesPreparationEmployeeId(
                dishesPreparationList.get(dishesPreparationList.size()-1).getId(), testUpdateEmployeeId);
        dishesPreparationController.updateDishesPreparationOrderId(
                dishesPreparationList.get(dishesPreparationList.size()-1).getId(), testUpdateOrderId);
        dishesPreparationController.updateDishesPreparationDate(
                dishesPreparationList.get(dishesPreparationList.size()-1).getId(), testUpdateOrderDate);
        DishesPreparation dishesPreparation = dishesPreparationController.findDishesPreparationById(
                dishesPreparationList.get(dishesPreparationList.size()-1).getId());
        assertEquals(dishesPreparation.getDishesId(), testUpdateDishesId);
        assertEquals(dishesPreparation.getEmployeeId(), testUpdateEmployeeId);
        assertEquals(dishesPreparation.getOrderId(), testUpdateOrderId);
        assertEquals(dishesPreparation.getDate(), testUpdateOrderDate);
    }

}