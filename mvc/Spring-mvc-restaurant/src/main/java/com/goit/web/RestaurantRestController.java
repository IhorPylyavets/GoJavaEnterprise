package com.goit.web;

import com.goit.model.Employee;
import com.goit.model.Menu;
import com.goit.model.Orders;
import com.goit.model.Position;
import com.goit.service.EmployeeService;
import com.goit.service.MenuService;
import com.goit.service.OrderService;
import com.goit.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RestaurantRestController {

    private MenuService menuService;
    private EmployeeService employeeService;
    private OrderService orderService;

    /*@RequestMapping(value = "/rest/menus", method = RequestMethod.GET)
    public List<Menu> menus(Map<String, Object> model) {
        return menuService.getAllMenu();
    }*/

    @RequestMapping(value = "/rest/menus/menusTitle", method = RequestMethod.GET)
    public List<String> menusTitle(Map<String, Object> model) {
        List<Menu> menus = menuService.getAllMenu();
        List<String> menusTitle = new ArrayList<>();
        for (Menu menu : menus) {
            menusTitle.add(menu.getMenuTitle());
        }
        return menusTitle;
    }

    /*@RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
    public Menu menu(@PathVariable int id) {
        return menuService.findMenuById(id);
    }*/

    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public List<Orders> orders(Map<String, Object> model) {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/rest/employees", method = RequestMethod.GET)
    public List<Employee> employees(Map<String, Object> model) {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/rest/employees/{id}", method = RequestMethod.GET)
    public Employee employee(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
