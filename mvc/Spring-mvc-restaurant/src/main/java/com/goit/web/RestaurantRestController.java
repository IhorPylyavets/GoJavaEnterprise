package com.goit.web;

import com.goit.model.Employee;
import com.goit.model.EmployeeSimple;
import com.goit.model.Menu;
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

    @RequestMapping(value = "/rest/menus/menusTitle", method = RequestMethod.GET)
    public List<String> menusTitle(Map<String, Object> model) {
        List<Menu> menus = menuService.getAllMenu();
        List<String> menusTitle = new ArrayList<>();
        for (Menu menu : menus) {
            menusTitle.add(menu.getMenuTitle());
        }
        return menusTitle;
    }

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
