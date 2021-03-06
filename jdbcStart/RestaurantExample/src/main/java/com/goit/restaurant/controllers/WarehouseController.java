package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.WarehouseDao;
import com.goit.restaurant.model.Warehouse;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class WarehouseController {
    private PlatformTransactionManager txManager;
    private WarehouseDao warehouseDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }

    @Transactional
    public void createWarehouse(Warehouse warehouse) {
        warehouseDao.createWarehouse(warehouse);
    }

    @Transactional
    public List<Warehouse> getAllWarehouse() {
        return warehouseDao.getAllWarehouse();
    }

    @Transactional
    public Warehouse findWarehouseById(int id) {
        return warehouseDao.findWarehouseById(id);
    }

    @Transactional
    public void deleteWarehouse(int id) {
        warehouseDao.deleteWarehouse(id);
    }

    @Transactional
    public void updateWarehouseIngredientId(int id, int newWarehouseIngredientId) {
        warehouseDao.updateWarehouseIngredientId(id, newWarehouseIngredientId);
    }

    @Transactional
    public void updateWarehouseAmount(int id, float newWarehouseAmount) {
        warehouseDao.updateWarehouseAmount(id, newWarehouseAmount);
    }

}
