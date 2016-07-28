package com.goit.restaurant.dao;

import com.goit.restaurant.model.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PositionDaoImpl implements PositionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(PositionDaoImpl.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void createPosition(String positionTitle) {
        String sql = "INSERT INTO POSITIONS (POSITION_TITLE) VALUES (?)";
        jdbcTemplateObject.update(sql, positionTitle);
        LOGGER.info(String.format("Position with POSITION_TITLE %s is creating in DB", positionTitle));
    }

    @Override
    public Position loadPositionById(int id) {
        String SQL = "SELECT * FROM POSITIONS where ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new PositionMapper());
    }

    @Override
    public List<Position> getAllPosition() {
        String SQL = "SELECT * FROM POSITIONS";
        return jdbcTemplateObject.query(SQL, new PositionMapper());
    }

    @Override
    public void deletePosition(int id) {
        String SQL = "DELETE FROM POSITIONS WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Position with %d is deleting from DB", id));
    }

    @Override
    public void updatePositionTitle(int id, String newTitle) {
        String SQL = "UPDATE POSITIONS SET POSITION_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newTitle, id);
        LOGGER.info(String.format("Position with %d is updating in DB", id));
    }

}
