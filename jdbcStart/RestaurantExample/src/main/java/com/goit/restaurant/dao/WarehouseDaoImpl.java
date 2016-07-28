package com.goit.restaurant.dao;

import com.goit.restaurant.dao.mappers.WarehouseMapper;
import com.goit.restaurant.dao.restaurantintefraces.WarehouseDao;
import com.goit.restaurant.model.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseDaoImpl.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createWarehouse(int ingredientId, int amount) {
        String sql = "INSERT INTO WAREHOUSE (INGREDIENT_ID, AMOUNT) VALUES (?, ?)";
        jdbcTemplateObject.update(sql, ingredientId, amount);
        LOGGER.info(String.format("Warehouse with parameters {%d, %d} is creating in DB", ingredientId, amount));
    }

    @Override
    @Transactional
    public Warehouse loadWarehouseById(int id) {
        String SQL = "SELECT * FROM WAREHOUSE where ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new WarehouseMapper());
    }

    @Override
    @Transactional
    public List<Warehouse> getAllWarehouse() {
        String SQL = "SELECT * FROM WAREHOUSE";
        return jdbcTemplateObject.query(SQL, new WarehouseMapper());
    }

    @Override
    @Transactional
    public void deleteWarehouse(int id) {
        String SQL = "DELETE FROM WAREHOUSE WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Warehouse with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateWarehouseIngredientId(int id, int newWarehouseIngredientId) {
        String SQL = "UPDATE WAREHOUSE SET INGREDIENT_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newWarehouseIngredientId, id);
        LOGGER.info(String.format("Warehouse with %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateWarehouseAmount(int id, int newWarehouseAmount) {
        String SQL = "UPDATE WAREHOUSE SET AMOUNT = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newWarehouseAmount, id);
        LOGGER.info(String.format("Warehouse with %d is updating in DB", id));
    }

}
