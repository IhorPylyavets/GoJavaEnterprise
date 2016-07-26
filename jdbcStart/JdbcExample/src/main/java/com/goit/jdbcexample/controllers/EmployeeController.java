package com.goit.jdbcexample.controllers;

import com.goit.jdbcexample.model.Employee;
import com.goit.jdbcexample.model.jdbc.EmployeeDao;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class EmployeeController {
    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.REQUIRED) // default propagation
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
    /*public List<Employee> getAllEmployee() {
        TransactionStatus status = txManager
                .getTransaction(new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED));
        try {
            List<Employee> result = employeeDao.getAllEmployee();
            txManager.commit(status);
            return result;
        } catch (Exception e) {
            txManager.rollback(status);
            throw new RuntimeException(e);
        }
    }*/

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Employee getEmployeeById(int id) {
        return employeeDao.load(id);
    }
}
