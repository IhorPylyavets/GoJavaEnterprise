package com.goit.restaurant.dao;

import com.goit.restaurant.model.Stock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StockDaoImplTest {
    private StockDao stockDao;

    @Before
    public void init() {
        stockDao = new StockDaoImpl();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Stock createStock = stockDao.create(ingredientId, amount);
        Stock stock = stockDao.load(createStock.getId());
        assertTrue(createStock.equals(stock));

        stockDao.delete(createStock.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteEmployee() throws Exception {
        int ingredientId = 1;
        int amount = 243;

        Stock createStock = stockDao.create(ingredientId, amount);
        stockDao.delete(createStock.getId());
        Stock stock = stockDao.load(createStock.getId());
    }

    @Test
    public void testReadMetaData() throws Exception {
        String metaData = stockDao.readMetadata();
        System.out.println(metaData);
    }
}