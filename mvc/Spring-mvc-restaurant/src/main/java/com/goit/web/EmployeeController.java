package com.goit.web;

import com.goit.model.Employee;
import com.goit.service.EmployeeService;
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
public class EmployeeController {

    private EmployeeService employeeService;
    private PositionService positionService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
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

        model.addAttribute("positionList", positionService.getAllPosition());

        return "employees/employee_form";
    }

    @RequestMapping(value = "/employees/create", method = RequestMethod.GET)
    public String showCreateEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee_form", employee);
        model.addAttribute("positionList", positionService.getAllPosition());

        return "employees/employee_form";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employee_form") @Validated Employee employee,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "employees/employee_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(employee.getId() == 0){
                redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");
                employeeService.createEmployee(employee);
            }else{
                redirectAttributes.addFlashAttribute("msg", "Employee updated successfully!");
                employeeService.updateEmployeeLastName(employee.getId(), employee.getLastName());
                employeeService.updateEmployeeFirstName(employee.getId(), employee.getFirstName());
                employeeService.updateEmployeeBirthday(employee.getId(), employee.getBirthday());
                employeeService.updateEmployeePhone(employee.getId(), employee.getPhone());
                employeeService.updateEmployeePositionId(employee.getId(), employee.getPosition().getId());
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
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
