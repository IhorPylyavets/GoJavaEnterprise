package com.goit.restaurant.dao;

import com.goit.restaurant.dao.mappers.DishMapper;
import com.goit.restaurant.dao.restaurantintefraces.DishDao;
import com.goit.restaurant.model.Dish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class JdbcDishDao implements DishDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDishDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createDish(String dishTitle, int categoryId, float price, float weight) {
        String sql = "INSERT INTO DISHES (DISHE_TITLE, CATEGORY_ID, PRICE, WEIGHT) VALUES (?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, dishTitle, categoryId, price, weight);
        LOGGER.info(String.format("Dish with parameters {%s, %d, %f, %f} is creating in DB",
                dishTitle, categoryId, price, weight));
    }

    @Override
    @Transactional
    public Dish findDishById(int id) {
        String SQL = "SELECT * FROM DISHES WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new DishMapper());
    }

    @Override
    @Transactional
    public List<Dish> getAllDish() {
        String SQL = "SELECT * FROM DISHES";
        return jdbcTemplateObject.query(SQL, new DishMapper());
    }

    @Override
    @Transactional
    public void deleteDish(int id) {
        String SQL = "DELETE FROM DISHES WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Dish with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateDishTitle(int id, String newDishTitle) {
        String SQL = "UPDATE DISHES SET DISHE_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishTitle, id);
        LOGGER.info(String.format("Dish with id %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishCategoryId(int id, int newDishCategoryId) {
        String SQL = "UPDATE DISHES SET CATEGORY_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishCategoryId, id);
        LOGGER.info(String.format("Dish with id %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishPrice(int id, float newDishPrice) {
        String SQL = "UPDATE DISHES SET PRICE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishPrice, id);
        LOGGER.info(String.format("Dish with id %d is updating in DB", id));
    }

    @Override
    @Transactional
    public void updateDishWeight(int id, float newDishWeight) {
        String SQL = "UPDATE DISHES SET WEIGHT = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDishWeight, id);
        LOGGER.info(String.format("Dish with id %d is updating in DB", id));
    }

}
