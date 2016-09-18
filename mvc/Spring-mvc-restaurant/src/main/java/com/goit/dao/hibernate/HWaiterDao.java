package com.goit.dao.hibernate;

import com.goit.dao.WaiterDao;
import com.goit.model.Employee;
import com.goit.model.Waiter;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class HWaiterDao implements WaiterDao {

    private SessionFactory sessionFactory;

    @Transactional
    public void createEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Waiter findWaiterByFullName(String lastName, String firstName) {
        return null;
    }
}
