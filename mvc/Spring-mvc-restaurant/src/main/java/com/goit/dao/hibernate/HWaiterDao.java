package com.goit.dao.hibernate;

import com.goit.dao.WaiterDao;
import com.goit.model.Employee;
import com.goit.model.Waiter;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class HWaiterDao extends HEmployeeDao {

    private SessionFactory sessionFactory;

    @Transactional
    public Waiter findWaiterByFullName(String lastName, String firstName) {
        return null;
    }

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
