/*
package com.goit.web;

import com.goit.service.DishesPreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DishesPreparationController {

    private DishesPreparationService dishesPreparationService;

    @Autowired
    public void setDishesPreparationService(DishesPreparationService dishesPreparationService) {
        this.dishesPreparationService = dishesPreparationService;
    }

    @RequestMapping(value = "/dishes_preparations", method = RequestMethod.GET)
    public String showAllDishes(Model model) {
        model.addAttribute("dishes_preparations", dishesPreparationService.getAllDishesPreparation());
        return "dishes_preparations/list_dishes_preparations";
    }
}
*/
