package com.goit.web;

import com.goit.dao.DeskDao;
import com.goit.dao.DishDao;
import com.goit.dao.EmployeeDao;
import com.goit.dao.PositionDao;
import com.goit.model.Dish;
import com.goit.model.Employee;
import com.goit.model.Orders;
import com.goit.service.OrderService;
import com.goit.web.validators.OrdersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class OrderController {

    private OrderService orderService;
    private EmployeeDao employeeDao;
    private PositionDao positionDao;
    private DeskDao deskDao;
    private DishDao dishDao;

    @Autowired
    private OrdersValidator ordersValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(ordersValidator);

        binder.registerCustomEditor(Employee.class, "waiter", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(employeeDao.findEmployeeById(Integer.valueOf(text)));
            }
        });

        binder.registerCustomEditor(Dish.class, "dishesInOrder", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(dishDao.findDishByTitle(text));
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String showAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders/list_orders";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String showOrder(@PathVariable("id") int id, Model model) {
        Orders order = orderService.findOrderById(id);
        if (order == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Order not found");
        }

        model.addAttribute("order", order);
        return "orders/show";
    }

    @RequestMapping(value = "/orders/{id}/delete", method = RequestMethod.POST)
    public String deleteOrder(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        orderService.deleteOrder(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Order is deleted!");

        return "redirect:/orders";
    }

    @RequestMapping(value = "/orders/{id}/update", method = RequestMethod.GET)
    public String showUpdateOrderForm(@PathVariable("id") int id, Model model) {
        Orders order = orderService.findOrderById(id);
        model.addAttribute("order_form", order);
        model.addAttribute("waiterList", employeeDao.getAllEmployeesByPosition(positionDao.findByTitle("waiter")));
        model.addAttribute("deskList", deskDao.getAll()); //getAllFreeDesk());
        model.addAttribute("dishesAll", dishDao.getAllDish());

        return "orders/order_form";
    }

    @RequestMapping(value = "/orders/create", method = RequestMethod.GET)
    public String showCreateOrderForm(Model model) {
        Orders order = new Orders();
        model.addAttribute("order_form", order);
        model.addAttribute("waiterList", employeeDao.getAllEmployeesByPosition(positionDao.findByTitle("waiter")));
        model.addAttribute("deskList", deskDao.getAll()); //getAllFreeDesk());
        model.addAttribute("dishesAll", dishDao.getAllDish());

        return "orders/order_form";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String saveOrUpdateOrders(@ModelAttribute("order_form") @Validated Orders orders,
                                     BindingResult result, final RedirectAttributes redirectAttributes) {


        if (result.hasErrors()) {
            System.out.println("jdhfvblzsdf;vb; " + orders);
            return "orders/order_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(orders.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Orders added successfully!");
                orders.setDesk(deskDao.findByTitle(orders.getDesk().getDeskTitle()));
                orderService.createOrder(orders);

            }else{
                redirectAttributes.addFlashAttribute("msg", "Orders updated successfully!");
                /*employeeService.updateEmployeeLastName(employee.getId(), employee.getLastName());
                employeeService.updateEmployeeFirstName(employee.getId(), employee.getFirstName());
                employeeService.updateEmployeeBirthday(employee.getId(), employee.getBirthday());
                employeeService.updateEmployeePhone(employee.getId(), employee.getPhone());
                employeeService.updateEmployeePositionId(employee.getId(),
                        positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
                employeeService.updateEmployeeSalary(employee.getId(), employee.getSalary());*/
            }

            return "redirect:/orders/" + orders.getId();
        }

    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Autowired
    public void setDeskDao(DeskDao deskDao) {
        this.deskDao = deskDao;
    }

    @Autowired
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
