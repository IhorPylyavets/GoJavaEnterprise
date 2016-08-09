package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.PositionDao;
import com.goit.restaurant.model.Position;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionController {

    private PlatformTransactionManager txManager;
    private PositionDao positionDao;

    @Transactional
    public void createPosition(Position position) {
        positionDao.createPosition(position);
    }

    @Transactional
    public Position findPositionById(int id) {
        return positionDao.findPositionById(id);
    }

    @Transactional
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Transactional
    public void deletePosition(int id) {
        positionDao.deletePosition(id);
    }

    @Transactional
    public void updatePositionTitle(int id, String newTitle) {
        positionDao.updatePositionTitle(id, newTitle);
    }

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
}
