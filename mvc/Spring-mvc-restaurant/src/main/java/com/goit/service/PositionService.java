package com.goit.service;

import com.goit.dao.PositionDao;
import com.goit.model.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PositionService {

    private PositionDao positionDao;

    @Transactional
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
}
