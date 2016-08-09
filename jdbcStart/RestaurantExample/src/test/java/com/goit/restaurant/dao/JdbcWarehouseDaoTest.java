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

        Warehouse warehouse = new Warehouse();
        int testIngredientId = 1;
        float testAmount = 23.2F;
        warehouse.setIngredientId(testIngredientId);
        warehouse.setAmount(testAmount);
        warehouseController.createWarehouse(warehouse);

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
        Warehouse warehouse = new Warehouse();
        int testIngredientId = 1;
        float testAmount = 23.2F;
        warehouse.setIngredientId(testIngredientId);
        warehouse.setAmount(testAmount);
        warehouseController.createWarehouse(warehouse);

        List<Warehouse> warehouseList = warehouseController.getAllWarehouse();
        Warehouse warehouseCurrent = warehouseController.findWarehouseById(warehouseList.get(warehouseList.size()-1).getId());
        assertEquals(warehouseCurrent.getIngredientId(), testIngredientId);
        assertEquals(warehouseCurrent.getAmount(), testAmount, 0.01);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdateWarehouseTitle() throws Exception {
        Warehouse warehouse = new Warehouse();
        int testIngredientId = 1;
        float testAmount = 23.2F;
        warehouse.setIngredientId(testIngredientId);
        warehouse.setAmount(testAmount);
        warehouseController.createWarehouse(warehouse);

        int testUpdateIngredientId = 2;
        float testUpdateAmount = 42.6F;
        List<Warehouse> warehouseList = warehouseController.getAllWarehouse();
        warehouseController.updateWarehouseIngredientId(warehouseList.get(warehouseList.size()-1).getId(), testUpdateIngredientId);
        warehouseController.updateWarehouseAmount(warehouseList.get(warehouseList.size()-1).getId(), testUpdateAmount);
        Warehouse warehouseCurrent = warehouseController.findWarehouseById(warehouseList.get(warehouseList.size()-1).getId());
        assertEquals(warehouseCurrent.getIngredientId(), testUpdateIngredientId);
        assertEquals(warehouseCurrent.getAmount(), testUpdateAmount, 0.01);
    }

}