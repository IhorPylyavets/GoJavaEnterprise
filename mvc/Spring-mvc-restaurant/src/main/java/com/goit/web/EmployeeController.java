package com.goit.web;

import com.goit.model.Employee;
import com.goit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

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

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
