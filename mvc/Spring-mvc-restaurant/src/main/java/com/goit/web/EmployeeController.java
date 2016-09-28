package com.goit.web;

import com.goit.dao.PositionDao;
import com.goit.model.Employee;
import com.goit.service.EmployeeService;
import com.goit.web.validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private PositionDao positionDao;

    @Autowired
    private EmployeeValidator employeeValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(employeeValidator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());

        return "employees/list_employees";
    }

    @RequestMapping(value = "/employees/search", method = RequestMethod.GET)
    public String findEmployeeByLastName(@RequestParam("lastName")String lastName, Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByLastName(lastName));
        return "employees/list_employees";
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public String showEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Employee not found");
        }
        model.addAttribute("employee", employee);
        return "employees/show";
    }

    @RequestMapping(value = "/employees/{id}/delete", method = RequestMethod.POST)
    public String deletePosition(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Employee is deleted!");

        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/{id}/update", method = RequestMethod.GET)
    public String showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id);
        model.addAttribute("employee_form", employee);
        model.addAttribute("positionList", positionDao.getAll());

        return "employees/employee_form";
    }

    @RequestMapping(value = "/employees/create", method = RequestMethod.GET)
    public String showCreateEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee_form", employee);
        model.addAttribute("positionList", positionDao.getAll());

        return "employees/employee_form";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employee_form") @Validated Employee employee,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "employees/employee_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(employee.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");

                employee.setPosition(positionDao.findByTitle(employee.getPosition().getPositionTitle()));
                employeeService.createEmployee(employee);

            }else{
                redirectAttributes.addFlashAttribute("msg", "Employee updated successfully!");
                employeeService.updateEmployeeLastName(employee.getId(), employee.getLastName());
                employeeService.updateEmployeeFirstName(employee.getId(), employee.getFirstName());
                employeeService.updateEmployeeBirthday(employee.getId(), employee.getBirthday());
                employeeService.updateEmployeePhone(employee.getId(), employee.getPhone());
                employeeService.updateEmployeePositionId(employee.getId(),
                        positionDao.findByTitle(employee.getPosition().getPositionTitle()));
                employeeService.updateEmployeeSalary(employee.getId(), employee.getSalary());
            }

            return "redirect:/employees/" + employee.getId();
        }

    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

}
