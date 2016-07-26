package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;

import java.util.List;

public interface PositionDao {
    Position createPosition(String positionTitle);
    Position loadPositionById(int id);
    List<Position> getAllPosition();
    void deletePosition(int id);
    void updatePosition(int id, String newTitle);
    String readPositionMetadata();
}
