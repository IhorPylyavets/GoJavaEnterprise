package com.goit.dao;

import com.goit.model.Desk;
import com.goit.model.DeskStatus;

import java.util.List;

public interface DeskDao extends SimpleDao<Desk>{
    List<Desk> getAllFreeDesk();
    void updateStatus(int id, DeskStatus deskStatus);
}
