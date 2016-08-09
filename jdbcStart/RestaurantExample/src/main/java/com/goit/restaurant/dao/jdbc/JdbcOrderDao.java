package com.goit.restaurant.dao.jdbc;

import com.goit.restaurant.dao.jdbc.mappers.OrderMapper;
import com.goit.restaurant.dao.OrderDao;
import com.goit.restaurant.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

public class JdbcOrderDao implements OrderDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcOrderDao.class);

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void createOrder(int employeeId, int deskId, Timestamp orderDate) {
        String sql = "INSERT INTO ORDERS (EMPLOYEE_ID, DESK_ID, ORDER_DATE) VALUES (?, ?, ?)";
        jdbcTemplateObject.update(sql, employeeId, deskId, orderDate);
        LOGGER.info(String.format("Menu with {MENU_TITLE, DESK_ID, ORDER_DATE} : {%d, %d, %s} is creating in DB"
                , employeeId, deskId, orderDate));
    }

    @Override
    @Transactional
    public Order findOrderById(int id) {
        String SQL = "SELECT * FROM ORDERS WHERE ID = ?";
        return jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new OrderMapper());
    }

    @Override
    @Transactional
    public List<Order> getAllOrder() {
        String SQL = "SELECT * FROM ORDERS";
        return jdbcTemplateObject.query(SQL, new OrderMapper());
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        String SQL = "DELETE FROM ORDERS WHERE ID = ?";
        jdbcTemplateObject.update(SQL, id);
        LOGGER.info(String.format("Order with %d is deleting from DB", id));
    }

    @Override
    @Transactional
    public void updateOrderEmployeeId(int id, int employeeId) {
        String SQL = "UPDATE ORDERS SET EMPLOYEE_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, employeeId, id);
        LOGGER.info(String.format("Order with %d is updating (EMPLOYEE_ID) to '%d' in DB", id, employeeId));
    }

    @Override
    @Transactional
    public void updateOrderDeskId(int id, int deskId) {
        String SQL = "UPDATE ORDERS SET DESK_ID = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, deskId, id);
        LOGGER.info(String.format("Order with %d is updating (DESK_ID) to '%d' in DB", id, deskId));
    }

    @Override
    @Transactional
    public void updateOrderDate(int id, Timestamp orderDate) {
        String SQL = "UPDATE ORDERS SET ORDER_DATE = ? WHERE ID = ?";
        jdbcTemplateObject.update(SQL, orderDate, id);
        LOGGER.info(String.format("Order with %d is updating (ORDER_DATE) to '%s' in DB", id, orderDate));
    }

}
