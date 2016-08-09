package com.goit.restaurant.dao;

import com.goit.restaurant.model.Desk;

import java.util.List;

public interface DeskDao {
    void createDesk(String deskTitle);
    Desk findDeskById(int id);
    List<Desk> getAllDesks();
    void deleteDesk(int id);
    void updateDeskTitle(int id, String newDeskTitle);
    //void updateDeskStatus(int id, Desk.DeskStatus deskStatus);
    //String readDeskMetadata();
}
