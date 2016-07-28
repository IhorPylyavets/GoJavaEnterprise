package com.goit.restaurant.dao;

import com.goit.restaurant.dao.mappers.CategoryMapper;
import com.goit.restaurant.dao.restaurantintefraces.CategoryDao;
import com.goit.restaurant.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryDaoImpl.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createCategory(String categoryTitle) {
        String sql = "INSERT INTO CATEGORIES (CATEGORY_TITLE) VALUES (?)";
        jdbcTemplateObject.update(sql, categoryTitle);
        LOGGER.info(String.format("Category with CATEGORY_TITLE %s is creating in DB", categoryTitle));
    }

    @Override
    @Transactional
    public Category loadCategoryById(int id) {
        String SQL = "SELECT * FROM CATEGORIES WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new CategoryMapper());
    }

    @Override
    @Transactional
    public List<Category> getAllCategory() {
        String SQL = "SELECT * FROM CATEGORIES";
        return jdbcTemplateObject.query(SQL, new CategoryMapper());
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        String SQL = "DELETE FROM CATEGORIES WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Category with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateCategoryTitle(int id, String newCategoryTitle) {
        String SQL = "UPDATE CATEGORIES SET CATEGORY_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newCategoryTitle, id);
        LOGGER.info(String.format("Category with id %d is updating in DB", id));
    }
}
