package com.goit.web;

import com.goit.model.Dish;
import com.goit.model.Ingredient;
import com.goit.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DishController {

    private DishService dishService;

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String showAllDishes(Model model) {
        model.addAttribute("dishes", dishService.getAllDish());
        return "dishes/list_dishes";
    }

    @RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
    public String showDishes(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findDishById(id);

        /*List<Ingredient> ingredients = dish.getIngredients();
        for (Ingredient i : ingredients) {
            System.out.println(i);
        }*/

        if (dish == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Dish not found");
        }
        model.addAttribute("dish", dish);
        return "dishes/show";
    }
}
