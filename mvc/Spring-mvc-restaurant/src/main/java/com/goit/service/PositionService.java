package com.goit.service;

import com.goit.dao.PositionDao;
import com.goit.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionService {

    private PositionDao positionDao;

    @Transactional
    public void createPosition(Position position) {
        positionDao.create(position);
    }

    @Transactional
    public Position findPositionById(int id) {
        return positionDao.findById(id);
    }

    @Transactional
    public Position findPositionByTitle(String positionTitle) {
        return positionDao.findByTitle(positionTitle);
    }

    @Transactional
    public List<Position> getAllPosition() {
        return positionDao.getAll();
    }

    @Transactional
    public void deletePosition(int id) {
        positionDao.delete(id);
    }

    @Transactional
    public void updatePositionTitle(int id, String newPositionTitle) {
        positionDao.updateTitle(id, newPositionTitle);
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
}
