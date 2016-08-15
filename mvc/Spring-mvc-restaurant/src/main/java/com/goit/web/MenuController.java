package com.goit.web;

import com.goit.model.Menu;
import com.goit.model.Position;
import com.goit.service.MenuService;
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
public class MenuController {

    private MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public String showAllPositions(Model model) {
        model.addAttribute("menus", menuService.getAllMenu());
        return "menus/list_menus";
    }

    @RequestMapping(value = "/menus/{id}", method = RequestMethod.GET)
    public String showMenu(@PathVariable("id") int id, Model model) {
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

        return "menus/menu_form";
    }

    @RequestMapping(value = "/menus/create", method = RequestMethod.GET)
    public String showCreatePositionForm(Model model) {
        Menu menu = new Menu();
        model.addAttribute("menu_form", menu);

        return "menus/menu_form";
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public String saveOrUpdatePosition(@ModelAttribute("menu_form") @Validated Menu menu,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "menus/menu_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(menu.getId() == 0){
                redirectAttributes.addFlashAttribute("msg", "Menu added successfully!");
                menuService.createMenu(menu);
            }else{
                redirectAttributes.addFlashAttribute("msg", "Menu updated successfully!");
                menuService.updateMenuTitle(menu.getId(), menu.getMenuTitle());
            }

            return "redirect:/menus/" + menu.getId();
        }

    }

}
