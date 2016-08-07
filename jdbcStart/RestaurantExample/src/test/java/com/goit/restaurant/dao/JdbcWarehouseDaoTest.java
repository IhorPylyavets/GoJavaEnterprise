package com.goit.restaurant.dao;

import com.goit.restaurant.controllers.WarehouseController;
import com.goit.restaurant.model.Warehouse;
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
public class JdbcWarehouseDaoTest {

    @Autowired
    private WarehouseController warehouseController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteWarehouse() throws Exception {
        List<Warehouse> warehouseList = warehouseController.getAllWarehouse();
        int testIngredientId = 1;
        float testAmount = 23.2F;
        warehouseController.createWarehouse(testIngredientId, testAmount);
        List<Warehouse> warehouseListCurrent = warehouseController.getAllWarehouse();
        assertEquals(warehouseList.size(), warehouseListCurrent.size()-1);
        assertEquals(warehouseListCurrent.get(warehouseListCurrent.size()-1).getIngredientId(), testIngredientId);
        assertEquals(warehouseListCurrent.get(warehouseListCurrent.size()-1).getAmount(), testAmount, 0.01);

        warehouseController.deleteWarehouse(warehouseListCurrent.get(warehouseListCurrent.size()-1).getId());
        warehouseListCurrent = warehouseController.getAllWarehouse();
        assertEquals(warehouseList.size(), warehouseListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindWarehouseById() throws Exception {
        int testIngredientId = 1;
        float testAmount = 23.6F;
        warehouseController.createWarehouse(testIngredientId, testAmount);
        List<Warehouse> warehouseList = warehouseController.getAllWarehouse();
        Warehouse warehouse = warehouseController.findWarehouseById(warehouseList.get(warehouseList.size()-1).getId());
        assertEquals(warehouse.getIngredientId(), testIngredientId);
        assertEquals(warehouse.getAmount(), testAmount, 0.01);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateWarehouseTitle() throws Exception {
        int testIngredientId = 1;
        float testAmount = 23.0F;
        warehouseController.createWarehouse(testIngredientId, testAmount);
        int testUpdateIngredientId = 2;
        float testUpdateAmount = 42.6F;
        List<Warehouse> warehouseList = warehouseController.getAllWarehouse();
        warehouseController.updateWarehouseIngredientId(warehouseList.get(warehouseList.size()-1).getId(), testUpdateIngredientId);
        warehouseController.updateWarehouseAmount(warehouseList.get(warehouseList.size()-1).getId(), testUpdateAmount);
        Warehouse warehouse = warehouseController.findWarehouseById(warehouseList.get(warehouseList.size()-1).getId());
        assertEquals(warehouse.getIngredientId(), testUpdateIngredientId);
        assertEquals(warehouse.getAmount(), testUpdateAmount, 0.01);
    }

}