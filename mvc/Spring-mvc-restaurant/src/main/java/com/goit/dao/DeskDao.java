package com.goit.dao;

import com.goit.model.Desk;
import com.goit.model.DeskStatus;

public interface DeskDao extends SimpleDao<Desk>{
    void updateStatus(int id, DeskStatus deskStatus);
}
