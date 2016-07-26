package com.goit.restaurant.controllers;

import com.goit.restaurant.dao.DeskDao;
import com.goit.restaurant.model.Desk;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DeskController {
    private PlatformTransactionManager txManager;
    private DeskDao deskDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setDeskDao(DeskDao deskDao) {
        this.deskDao = deskDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Desk createDesk(String deskTitle) {
        return deskDao.createDesk(deskTitle);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Desk> getAllPosition() {
        return deskDao.getAllDesks();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Desk loadDeskById(int id) {
        return deskDao.loadDeskById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDesk(int id) {
        deskDao.deleteDesk(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateDeskTitle(int id, String newDeskTitle) {
        deskDao.updateDeskTitle(id, newDeskTitle);
    }

    /*@Transactional(propagation = Propagation.REQUIRED)
    public void updateDeskStatus(int id, Desk.DeskStatus deskStatus) {
        deskDao.updateDeskStatus(id, deskStatus);
    }*/

    @Transactional(propagation = Propagation.REQUIRED)
    public String readDeskMetadata() {
        return deskDao.readDeskMetadata();
    }
}
