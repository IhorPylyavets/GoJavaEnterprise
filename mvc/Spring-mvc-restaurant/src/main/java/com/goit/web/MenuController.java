package com.goit.web;

import com.goit.dao.DishDao;
import com.goit.model.Dish;
import com.goit.model.Menu;
import com.goit.service.DishService;
import com.goit.service.MenuService;
import com.goit.web.validators.MenuValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
public class MenuController {

    private MenuService menuService;
    private DishDao dishDao;

    @Autowired
    private MenuValidator menuValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(menuValidator);

        binder.registerCustomEditor(Dish.class, "dishesList", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(dishDao.findDishByTitle(text));
            }
        });
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public String showAllMenus(Model model) {
        model.addAttribute("menus", menuService.getAllMenu());
        return "menus/list_menus";
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    public String showMenus(@PathVariable("id") int id, Model model) {
        Menu menu = menuService.findMenuById(id);

        if (menu == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Menu not found");
        }
        model.addAttribute("menu", menu);
        return "menus/show";
    }


    @RequestMapping(value = "/menus/{id}/delete", method = RequestMethod.POST)
    public String deleteMenu(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        menuService.deleteMenu(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Menu is deleted!");

        return "redirect:/menus";
    }

    @RequestMapping(value = "/menus/{id}/update", method = RequestMethod.GET)
    public String showUpdateMenuForm(@PathVariable("id") int id, Model model) {
        Menu menu = menuService.findMenuById(id);
        model.addAttribute("menu_form", menu);
        model.addAttribute("dishesAll", dishDao.getAllDish());

        return "menus/menu_form";
    }

    @RequestMapping(value = "/menus/create", method = RequestMethod.GET)
    public String showCreateMenuForm(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menu_form", menu);
        model.addAttribute("dishesAll", dishDao.getAllDish());

        return "menus/menu_form";
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public String saveOrUpdateMenu(@ModelAttribute("menu_form") @Validated Menu menu,
                                   BindingResult result, final RedirectAttributes redirectAttributes) {

        System.out.println(menu);

        if (result.hasErrors()) {
            return "menus/menu_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (menu.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Menu added successfully!");
                menuService.createMenu(menu);

            } else {
                redirectAttributes.addFlashAttribute("msg", "Menu updated successfully!");
                menuService.updateMenuTitle(menu.getId(), menu.getMenuTitle());
                menuService.updateMenuDishes(menu.getId(), menu.getDishesInMenu());
            }

            return "redirect:/menus/" + menu.getId();
        }

    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
