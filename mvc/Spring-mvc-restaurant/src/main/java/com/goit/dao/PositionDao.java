package com.goit.dao;

import com.goit.model.Position;

import java.util.List;

public interface PositionDao {
    void createPosition(Position position);
    Position findPositionById(int id);
    List<Position> getAllPosition();
    void deletePosition(int id);
    void updatePositionTitle(int id, String newTitle);
}
