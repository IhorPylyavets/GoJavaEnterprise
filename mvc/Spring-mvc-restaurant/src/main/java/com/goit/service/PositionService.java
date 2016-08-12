package com.goit.service;

import com.goit.dao.PositionDao;
import com.goit.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionService {

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
    public void updatePositionTitle(int id, String newPositionTitle) {
        positionDao.updatePositionTitle(id, newPositionTitle);
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
}
