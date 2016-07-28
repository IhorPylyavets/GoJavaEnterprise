package com.goit.restaurant.dao;

import com.goit.restaurant.dao.mappers.IngredientMapper;
import com.goit.restaurant.dao.restaurantintefraces.IngredientDao;
import com.goit.restaurant.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class IngredientDaoImpl implements IngredientDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientDaoImpl.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createIngredient(String ingredientTitle) {
        String sql = "INSERT INTO INGREDIENTS (INGREDIENT_TITLE) VALUES (?)";
        jdbcTemplateObject.update(sql, ingredientTitle);
        LOGGER.info(String.format("Ingredient with INGREDIENT_TITLE %s is creating in DB", ingredientTitle));
    }

    @Override
    @Transactional
    public Ingredient loadIngredientById(int id) {
        String SQL = "SELECT * FROM INGREDIENTS where ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new IngredientMapper());
    }

    @Override
    @Transactional
    public List<Ingredient> getAllIngredient() {
        String SQL = "SELECT * FROM INGREDIENTS";
        return jdbcTemplateObject.query(SQL, new IngredientMapper());
    }

    @Override
    @Transactional
    public void deleteIngredient(int id) {
        String SQL = "DELETE FROM INGREDIENTS WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Ingredient with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateIngredientTitle(int id, String newIngredientTitle) {
        String SQL = "UPDATE INGREDIENTS SET INGREDIENT_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newIngredientTitle, id);
        LOGGER.info(String.format("Ingredient with %d is updating in DB", id));
    }

}
