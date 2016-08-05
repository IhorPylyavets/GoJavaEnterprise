package com.goit.restaurant.dao;

import com.goit.restaurant.dao.mappers.DeskMapper;
import com.goit.restaurant.dao.restaurantintefraces.DeskDao;
import com.goit.restaurant.model.Desk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

public class JdbcDeskDao implements DeskDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDeskDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createDesk(String deskTitle) {
        String sql = "INSERT INTO DESKS (DESK_TITLE) VALUES (?)";
        jdbcTemplateObject.update(sql, deskTitle);
        LOGGER.info(String.format("Desk with DESK_TITLE %s is creating in DB", deskTitle));
    }

    @Override
    @Transactional
    public Desk findDeskById(int id) {
        String SQL = "SELECT * FROM DESKS WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new DeskMapper());
    }

    @Override
    @Transactional
    public List<Desk> getAllDesks() {
        String SQL = "SELECT * FROM DESKS";
        return jdbcTemplateObject.query(SQL, new DeskMapper());
    }

    @Override
    @Transactional
    public void deleteDesk(int id) {
        String SQL = "DELETE FROM DESKS WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Desk with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateDeskTitle(int id, String newDeskTitle) {
        String SQL = "UPDATE DESKS SET DESK_TITLE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, newDeskTitle, id);
        LOGGER.info(String.format("Desk with id %d is updating in DB", id));
    }

    /*@Override
    @Transactional
    public void updateDeskStatus(int id, Desk.DeskStatus deskStatus) {
        String SQL = "UPDATE DESKS SET STATUS_OF_DESK = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, deskStatus.toString(), id);
        LOGGER.info(String.format("Desk with %d is updating in DB", id));
    }*/

}
