package com.goit.restaurant.dao;

import com.goit.restaurant.model.Warehouse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WarehouseDaoImplTest {
    private WarehouseDao warehouseDao;

    @Before
    public void init() {
        warehouseDao = new WarehouseDaoImpl();
    }

    @Test
    public void testCreateWarehouse() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Warehouse createWarehouse = warehouseDao.create(ingredientId, amount);
        Warehouse warehouse = warehouseDao.load(createWarehouse.getId());
        assertTrue(createWarehouse.equals(warehouse));

        warehouseDao.delete(createWarehouse.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteWarehouse() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Warehouse createWarehouse = warehouseDao.create(ingredientId, amount);
        warehouseDao.delete(createWarehouse.getId());
        Warehouse warehouse = warehouseDao.load(createWarehouse.getId());
    }

    @Test
    public void testReadMetaData() throws Exception {
        String metaData = warehouseDao.readMetadata();
        System.out.println(metaData);
    }
}