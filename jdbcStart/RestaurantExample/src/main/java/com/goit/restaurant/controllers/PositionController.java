package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.PositionDao;
import com.goit.restaurant.model.Employee;
import com.goit.restaurant.model.Position;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionController {
    private PlatformTransactionManager txManager;
    private PositionDao positionDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Position createPosition(String positionTitle) {
        return positionDao.createPosition(positionTitle);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Position getPositionById(int id) {
        return positionDao.loadPositionById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePosition(int id, String newPositionTitle) {
        positionDao.updatePosition(id, newPositionTitle);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String readPositionMetadata() {
        return positionDao.readPositionMetadata();
    }
}
