package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;

import java.util.List;

public interface DeskDao {
    Desk createDesk(String deskNumber);
    Desk loadDesk(int id);
    List<Desk> getAllDesk();
    void deleteDesk(int id);
    void updateDesk(int id, String newDeskNumber);
    String readMetadata();
}
