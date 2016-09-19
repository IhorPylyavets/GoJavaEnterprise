package com.goit.web;

import com.goit.dao.DishDao;
import com.goit.dao.EmployeeDao;
import com.goit.dao.OrderDao;
import com.goit.dao.PositionDao;
import com.goit.model.DishesPreparation;
import com.goit.service.*;
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
public class DishesPreparationController {

    private DishesPreparationService dishesPreparationService;
    private EmployeeDao employeeDao;
    private PositionDao positionDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    @RequestMapping(value = "/dishes_preparations", method = RequestMethod.GET)
    public String showAllDishesPreparation(Model model) {
        model.addAttribute("dishes_preparations", dishesPreparationService.getAllDishesPreparation());
        return "dishes_preparations/list_dishes_preparations";
    }

    @RequestMapping(value = "/dishes_preparations/{id}", method = RequestMethod.GET)
    public String showDishesPreparation(@PathVariable("id") int id, Model model) {
        DishesPreparation dishesPreparation = dishesPreparationService.findDishesPreparationById(id);
        if (dishesPreparation == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "DishesPreparation not found");
        }
        model.addAttribute("dishesPreparation", dishesPreparation);
        return "dishes_preparations/show";
    }

    @RequestMapping(value = "/dishes_preparations/{id}/delete", method = RequestMethod.POST)
    public String deleteDishesPreparation(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        dishesPreparationService.deleteDishesPreparation(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "DishesPreparation is deleted!");

        return "redirect:/dishes_preparations";
    }

    @RequestMapping(value = "/dishes_preparations/{id}/update", method = RequestMethod.GET)
    public String showUpdateDishesPreparationForm(@PathVariable("id") int id, Model model) {
        DishesPreparation dishesPreparation = dishesPreparationService.findDishesPreparationById(id);
        model.addAttribute("dishes_preparation_form", dishesPreparation);
        model.addAttribute("cookList", employeeDao.getAllEmployeesByPosition(positionDao.findByTitle("cook")));
        model.addAttribute("dishList", dishDao.getAllDish());
        model.addAttribute("orderValuekList", orderDao.getAllOrders());

        return "dishes_preparations/dishes_preparation_form";
    }

    @RequestMapping(value = "/dishes_preparations/create", method = RequestMethod.GET)
    public String showCreateDishesPreparationForm(Model model) {
        DishesPreparation dishesPreparation = new DishesPreparation();
        model.addAttribute("dishes_preparation_form", dishesPreparation);
        model.addAttribute("cookList", employeeDao.getAllEmployeesByPosition(positionDao.findByTitle("cook")));
        model.addAttribute("dishList", dishDao.getAllDish());
        model.addAttribute("orderValuekList", orderDao.getAllOrders());

        /*List<Dish> d = dishService.getAllDish();
        for (Dish q : d) {
            System.out.println(q);
        }*/

        return "dishes_preparations/dishes_preparation_form";
    }

    @RequestMapping(value = "/dishes_preparations", method = RequestMethod.POST)
    public String saveOrUpdateDishesPreparation(@ModelAttribute("dishes_preparation_form") @Validated DishesPreparation dishesPreparation,
                                                BindingResult result, final RedirectAttributes redirectAttributes) {

        System.out.println("dishesPreparation: " + dishesPreparation);

        if (result.hasErrors()) {
            System.out.println("result.hasErrors()!!!");
            return "dishes_preparations/dishes_preparation_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(dishesPreparation.isNew()){
                redirectAttributes.addFlashAttribute("msg", "DishesPreparation added successfully!");

                //employee.setPosition(positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
                dishesPreparationService.createDishesPreparation(dishesPreparation);

            }else{
                redirectAttributes.addFlashAttribute("msg", "DishesPreparation updated successfully!");
                /*employeeService.updateEmployeeLastName(employee.getId(), employee.getLastName());
                employeeService.updateEmployeeFirstName(employee.getId(), employee.getFirstName());
                employeeService.updateEmployeeBirthday(employee.getId(), employee.getBirthday());
                employeeService.updateEmployeePhone(employee.getId(), employee.getPhone());
                employeeService.updateEmployeePositionId(employee.getId(),
                        positionService.findPositionByTitle(employee.getPosition().getPositionTitle()));
                employeeService.updateEmployeeSalary(employee.getId(), employee.getSalary());*/
            }

            return "redirect:/dishes_preparations/" + dishesPreparation.getId();
        }

    }

    @Autowired
    public void setDishesPreparationService(DishesPreparationService dishesPreparationService) {
        this.dishesPreparationService = dishesPreparationService;
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
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

}
