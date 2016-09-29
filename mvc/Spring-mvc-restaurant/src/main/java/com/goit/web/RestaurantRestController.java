package com.goit.web;

import com.goit.model.Employee;
import com.goit.model.EmployeeSimple;
import com.goit.model.Menu;
import com.goit.model.Orders;
import com.goit.service.EmployeeService;
import com.goit.service.MenuService;
import com.goit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class RestaurantRestController {

    private MenuService menuService;
    private EmployeeService employeeService;
    private OrderService orderService;

    //rest for menus
    @RequestMapping(value = "/rest/menus", method = RequestMethod.GET)
    public List<Menu> menus(Map<String, Object> model) {
        return menuService.getAllMenu();
    }

    @RequestMapping(value = "/rest/menus/menusTitle", method = RequestMethod.GET)
    public List<String> menusTitle(Map<String, Object> model) {
        List<Menu> menus = menuService.getAllMenu();
        List<String> menusTitle = new ArrayList<>();
        for (Menu menu : menus) {
            menusTitle.add(menu.getMenuTitle());
        }
        return menusTitle;
    }

    @RequestMapping(value = "/rest/menus/{id}", method = RequestMethod.GET)
    public Menu menuById(@PathVariable int id) {
        return menuService.findMenuById(id);
    }

    @RequestMapping(value = "/rest/menus/by_menuTitle", method = RequestMethod.GET)
    @ResponseBody
    public Menu menuByTitle(@RequestParam("menuTitle") String menuTitle) {
        return menuService.findMenuByTitle(menuTitle);
    }

    //rest for menus
    @RequestMapping(value = "/rest/orders", method = RequestMethod.GET)
    public List<Orders> orders(Map<String, Object> model) {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/rest/orders/{id}", method = RequestMethod.GET)
    public Orders ordersById(@PathVariable int id) {
        return orderService.findOrderById(id);
    }

    //rest for menus
    @RequestMapping(value = "/rest/employees", method = RequestMethod.GET)
    public List<EmployeeSimple> employees(Map<String, Object> model) {
        List<Employee> employees = employeeService.getAllEmployee();
        List<EmployeeSimple> employeeSimples = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeSimple simple = new EmployeeSimple();
            simple.setId(employee.getId());
            simple.setFirstName(employee.getFirstName());
            simple.setLastName(employee.getLastName());

            employeeSimples.add(simple);
        }

        return employeeSimples;
    }

    @RequestMapping(value = "/rest/employees/{id}", method = RequestMethod.GET)
    public Employee employeeById(@PathVariable int id) {
        return employeeService.findEmployeeById(id);
    }

    @RequestMapping(value = "/rest/employees/by_lastName", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> employeeByLastName(@RequestParam("lastName") String lastName) {
        return employeeService.findEmployeeByLastName(lastName);
    }

    @RequestMapping(value = "/rest/employees/by_firstName", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> employeeByFirstName(@RequestParam("firstName") String firstName) {
        return employeeService.findEmployeeByFirstName(firstName);
    }

    @RequestMapping(value = "/rest/employees/by_fullName", method = RequestMethod.GET)
    @ResponseBody
    public Employee employeeByFullName(@RequestParam("lastName") String lastName,
                                       @RequestParam("firstName") String firstName) {
        return employeeService.findEmployeeByFullName(lastName, firstName);
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
