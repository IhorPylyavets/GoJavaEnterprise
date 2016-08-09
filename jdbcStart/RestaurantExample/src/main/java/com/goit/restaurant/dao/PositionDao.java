package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;

import java.util.List;

public interface PositionDao {
    void createPosition(Position position);
    Position findPositionById(int id);
    List<Position> getAllPosition();
    void deletePosition(int id);
    void updatePositionTitle(int id, String newTitle);
    //String readPositionMetadata();
}
