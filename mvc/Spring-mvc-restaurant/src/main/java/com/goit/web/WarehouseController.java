package com.goit.web;

import com.goit.model.Warehouse;
import com.goit.service.IngredientService;
import com.goit.service.WarehouseService;
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
public class WarehouseController {

    private WarehouseService warehouseService;
    private IngredientService ingredientService;

    @Autowired
    public void setWarehouseService(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/warehouses", method = RequestMethod.GET)
    public String showAllWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseService.getAllWarehouse());
        return "warehouses/list_warehouses";
    }

    @RequestMapping(value = "/warehouses/{id}", method = RequestMethod.GET)
    public String showWarehouse(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        if (warehouse == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Warehouse not found");
        }
        model.addAttribute("warehouse", warehouse);
        return "warehouses/show";
    }

    @RequestMapping(value = "/warehouses/{id}/delete", method = RequestMethod.POST)
    public String deleteWarehouse(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        warehouseService.deleteWarehouse(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Warehouse is deleted!");

        return "redirect:/warehouses";
    }

    @RequestMapping(value = "/warehouses/{id}/update", method = RequestMethod.GET)
    public String showUpdateWarehouseForm(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        model.addAttribute("warehouse_form", warehouse);
        model.addAttribute("ingredientList", ingredientService.getAllIngredient());

        return "warehouses/warehouse_form";
    }

    @RequestMapping(value = "/warehouses/create", method = RequestMethod.GET)
    public String showCreateWarehouseForm(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse_form", warehouse);
        model.addAttribute("ingredientList", ingredientService.getAllIngredient());

        return "warehouses/warehouse_form";
    }

    @RequestMapping(value = "/warehouses", method = RequestMethod.POST)
    public String saveOrUpdateWarehouse(@ModelAttribute("warehouse_form") @Validated Warehouse warehouse,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "warehouses/warehouse_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (warehouse.getId() == 0) {
                redirectAttributes.addFlashAttribute("msg", "Warehouse added successfully!");
                warehouseService.createWarehouse(warehouse);
            } else {
                redirectAttributes.addFlashAttribute("msg", "Warehouse updated successfully!");
                warehouseService.updateWarehouseIngredientId(warehouse.getId(),
                        ingredientService.findIngredientByTitle(warehouse.getIngredient().getIngredientTitle()));
                warehouseService.updateWarehouseAmount(warehouse.getId(), warehouse.getAmount());
            }

            return "redirect:/warehouses/" + warehouse.getId();
        }
    }
}
