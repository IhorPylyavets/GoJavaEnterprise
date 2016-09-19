package com.goit.web;

import com.goit.dao.DeskDao;
import com.goit.dao.EmployeeDao;
import com.goit.dao.PositionDao;
import com.goit.model.Orders;
import com.goit.service.DeskService;
import com.goit.service.EmployeeService;
import com.goit.service.OrderService;
import com.goit.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private OrderService orderService;
    private EmployeeDao employeeDao;
    private PositionDao positionDao;
    private DeskDao deskDao;

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

        return "orders/order_form";
    }

    @RequestMapping(value = "/orders/create", method = RequestMethod.GET)
    public String showCreateOrderForm(Model model) {
        Orders order = new Orders();
        model.addAttribute("order_form", order);
        model.addAttribute("waiterList", employeeDao.getAllEmployeesByPosition(positionDao.findByTitle("waiter")));
        model.addAttribute("deskList", deskDao.getAll()); //getAllFreeDesk());

        return "orders/order_form";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String saveOrUpdateOrders(@ModelAttribute("order_form") @Validated Orders orders,
                                     BindingResult result, final RedirectAttributes redirectAttributes) {

        System.out.println("saveOrUpdateOrders");
        System.out.println(orders);
        if (result.hasErrors()) {
            return "orders/order_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(orders.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Orders added successfully!");

                //employee.setPosition(positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
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

    /*@RequestMapping(value = "/orders", method = RequestMethod.POST)
    public String saveOrUpdateOrder(@ModelAttribute("order_form") @Validated Orders order,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        System.out.println(order);

        if (result.hasErrors()) {
            System.out.println("saveOrUpdateOrder error");
            return "orders/order_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(order.getId() == 0){
                redirectAttributes.addFlashAttribute("msg", "Order added successfully!");

                //employee.setPosition(positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
                //employeeService.createEmployee(employee);
                orderService.createOrder(order);

            }else{
                redirectAttributes.addFlashAttribute("msg", "Order updated successfully!");
                *//*orderService.updateOrderWaiterId(order.getId(), order.getWaiter());
                orderService.updateOrderDeskId(order.getId(), order.getDesk());
                orderService.updateOrderDate(order.getId(), order.getOrderDate());*//*


                *//*employeeService.updateEmployeeLastName(employee.getId(), employee.getLastName());
                employeeService.updateEmployeeFirstName(employee.getId(), employee.getFirstName());
                employeeService.updateEmployeeBirthday(employee.getId(), employee.getBirthday());
                employeeService.updateEmployeePhone(employee.getId(), employee.getPhone());
                employeeService.updateEmployeePositionId(employee.getId(),
                        positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
                employeeService.updateEmployeeSalary(employee.getId(), employee.getSalary());*//*
            }

            return "redirect:/orders/" + order.getId();
        }

    }*/

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
}
