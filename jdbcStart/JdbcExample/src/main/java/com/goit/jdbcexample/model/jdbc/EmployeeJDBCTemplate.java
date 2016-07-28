package com.goit.jdbcexample.model.jdbc;

import com.goit.jdbcexample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeJDBCTemplate implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeJDBCTemplate.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        jdbcTemplateObject.update("INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?, ?)",
                employee.getId(), employee.getName(), employee.getAge(),
                employee.getAddress(), employee.getSalary(), employee.getJoinDate());
        LOGGER.info(String.format("Employee {%s} is inserting to DB", employee.toString()));
    }

    @Override
    @Transactional
    public Employee load(int id) {
        String SQL = "SELECT * FROM EMPLOYEE where ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new EmployeeMapper());
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        String SQL = "SELECT * FROM EMPLOYEE";
        return jdbcTemplateObject.query(SQL, new EmployeeMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
}
