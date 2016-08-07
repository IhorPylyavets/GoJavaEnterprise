package com.goit.restaurant.dao;

import com.goit.restaurant.Common;
import com.goit.restaurant.controllers.OrderController;
import com.goit.restaurant.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcOrderDaoTest {

    @Autowired
    private OrderController orderController;

    @Test
    @Transactional
    @Rollback(true)
    public void testCreateDeleteOrder() throws Exception {
        List<Order> orderList = orderController.getAllOrder();
        int testEmployeeId = 1;
        int testDeskId = 1;
        Timestamp testOrderDate = Common.stringToTimestamp("2007-09-23 10:10:10.0");
        orderController.createOrder(testEmployeeId, testDeskId, testOrderDate);

        List<Order> orderListCurrent = orderController.getAllOrder();
        assertEquals(orderList.size(), orderListCurrent.size()-1);
        assertEquals(orderListCurrent.get(orderListCurrent.size()-1).getEmployeeId(), testEmployeeId);
        assertEquals(orderListCurrent.get(orderListCurrent.size()-1).getDeskId(), testDeskId);
        assertEquals(orderListCurrent.get(orderListCurrent.size()-1).getOrderDate(), testOrderDate);

        orderController.deleteOrder(orderListCurrent.get(orderListCurrent.size()-1).getId());
        orderListCurrent = orderController.getAllOrder();
        assertEquals(orderList.size(), orderListCurrent.size());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testFindOrderById() throws Exception {
        int testEmployeeId = 1;
        int testDeskId = 1;
        Timestamp testOrderDate = Common.stringToTimestamp("2007-09-23 10:10:10.0");
        orderController.createOrder(testEmployeeId, testDeskId, testOrderDate);

        List<Order> orderList = orderController.getAllOrder();
        Order order = orderController.findOrderById(orderList.get(orderList.size()-1).getId());
        assertEquals(order.getEmployeeId(), testEmployeeId);
        assertEquals(order.getDeskId(), testDeskId);
        assertEquals(order.getOrderDate(), testOrderDate);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUpdatePositionTitle() throws Exception {
        int testEmployeeId = 1;
        int testDeskId = 1;
        Timestamp testOrderDate = Common.stringToTimestamp("2007-09-23 10:10:10.0");
        orderController.createOrder(testEmployeeId, testDeskId, testOrderDate);

        List<Order> orderList = orderController.getAllOrder();
        int testUpdateEmployeeId = 2;
        int testUpdateDeskId = 2;
        Timestamp testUpdateOrderDate = Common.stringToTimestamp("2009-02-21 11:12:17.0");
        orderController.updateOrderEmployeeId(orderList.get(orderList.size()-1).getId(), testUpdateEmployeeId);
        orderController.updateOrderDeskId(orderList.get(orderList.size()-1).getId(), testUpdateDeskId);
        orderController.updateOrderDate(orderList.get(orderList.size()-1).getId(), testUpdateOrderDate);
        Order order = orderController.findOrderById(orderList.get(orderList.size()-1).getId());
        assertEquals(order.getEmployeeId(), testUpdateEmployeeId);
        assertEquals(order.getDeskId(), testUpdateDeskId);
        assertEquals(order.getOrderDate(), testUpdateOrderDate);
    }

}