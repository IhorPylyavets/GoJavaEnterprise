package com.goit.restaurant.dao;


import com.goit.restaurant.dao.mappers.DishesPreparationMapper;
import com.goit.restaurant.dao.restaurantintefraces.DishesPreparationDao;
import com.goit.restaurant.model.DishesPreparation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

public class JdbcDishesPreparationDao implements DishesPreparationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDishesPreparationDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createDishesPreparation(int dishesId, int employeeId, int orderId, Timestamp date) {
        String sql = "INSERT INTO DISHES_PREPARATION (DISHES_ID, EMPLOYEE_ID, ORDER_ID, DATE_PREPARATIONS) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, dishesId, employeeId, orderId, date);
        LOGGER.info(String.format("DishesPreparation with parameters {%d, %d, %d, %s} is creating in DB",
                dishesId, employeeId, orderId, date));
    }

    @Override
    @Transactional
    public DishesPreparation findDishesPreparationById(int id) {
        String SQL = "SELECT * FROM DISHES_PREPARATION where ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new DishesPreparationMapper());
    }

    @Override
    @Transactional
    public List<DishesPreparation> getAllDishesPreparation() {
        String SQL = "SELECT * FROM DISHES_PREPARATION";
        return jdbcTemplateObject.query(SQL, new DishesPreparationMapper());
    }

    @Override
    @Transactional
    public void deleteDishesPreparation(int id) {
        String SQL = "DELETE FROM DISHES_PREPARATION WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("DishesPreparation with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateDishesPreparationEmployeeId(int id, int newDishesPreparationEmployeeId) {
        String SQL = "UPDATE DISHES_PREPARATION SET EMPLOYEE_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishesPreparationEmployeeId, id);
        LOGGER.info(String.format("DishesPreparation with %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishesPreparationDishesId(int id, int newDishesPreparationDishesId) {
        String SQL = "UPDATE DISHES_PREPARATION SET DISHES_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishesPreparationDishesId, id);
        LOGGER.info(String.format("DishesPreparation with %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishesPreparationOrderId(int id, int newDishesPreparationOrderId) {
        String SQL = "UPDATE DISHES_PREPARATION SET ORDER_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishesPreparationOrderId, id);
        LOGGER.info(String.format("DishesPreparation with %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishesPreparationDate(int id, Timestamp newDishesPreparationDate) {
        String SQL = "UPDATE DISHES_PREPARATION SET DATE_PREPARATIONS = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishesPreparationDate, id);
        LOGGER.info(String.format("DishesPreparation with %d is updating in DB", id));
    }

}
