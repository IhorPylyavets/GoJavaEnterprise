package com.goit.restaurant.dao;

import com.goit.restaurant.model.Warehouse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StockDaoImplTest {
    private WarehouseDao stockDao;

    @Before
    public void init() {
        stockDao = new WarehouseDaoImpl();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Warehouse createStock = stockDao.create(ingredientId, amount);
        Warehouse stock = stockDao.load(createStock.getId());
        assertTrue(createStock.equals(stock));

        stockDao.delete(createStock.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteEmployee() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Warehouse createStock = stockDao.create(ingredientId, amount);
        stockDao.delete(createStock.getId());
        Warehouse stock = stockDao.load(createStock.getId());
    }

    @Test
    public void testReadMetaData() throws Exception {
        String metaData = stockDao.readMetadata();
        System.out.println(metaData);
    }
}