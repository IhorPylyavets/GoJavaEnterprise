package com.goit.web;

import com.goit.dao.IngredientDao;
import com.goit.model.Dish;
import com.goit.model.Ingredient;
import com.goit.service.CategoryService;
import com.goit.service.DishService;
import com.goit.service.IngredientService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    private DishService dishService;
    private IngredientService ingredientService;
    private CategoryService categoryService;

    @Autowired
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String showAllDishes(Model model) {
        model.addAttribute("dishes", dishService.getAllDish());
        return "dishes/list_dishes";
    }

    @RequestMapping(value = "/dishes/{id}", method = RequestMethod.GET)
    public String showDishes(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findDishById(id);

        if (dish == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Dish not found");
        }
        model.addAttribute("dish", dish);
        return "dishes/show";
    }


    @RequestMapping(value = "/dishes/{id}/delete", method = RequestMethod.POST)
    public String deleteDish(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        dishService.deleteDish(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Dish is deleted!");

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/dishes/{id}/update", method = RequestMethod.GET)
    public String showUpdateDishForm(@PathVariable("id") int id, Model model) {
        Dish dish = dishService.findDishById(id);
        model.addAttribute("dish_form", dish);
        model.addAttribute("ingredientList", ingredientService.getAllIngredient());
        model.addAttribute("categoryList", categoryService.getAllCategories());

        return "dishes/dish_form";
    }

    @RequestMapping(value = "/dishes/create", method = RequestMethod.GET)
    public String showCreateDishForm(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dish_form", dish);
        model.addAttribute("ingredientList", ingredientService.getAllIngredient());
        model.addAttribute("categoryList", categoryService.getAllCategories());

        return "dishes/dish_form";
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.POST)
    public String saveOrUpdateDish(@ModelAttribute("dish_form") @Validated Dish dish,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        System.out.println("dish//// " + dish);

        if (result.hasErrors()) {
            return "dishes/dish_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (dish.getId() == 0){
                redirectAttributes.addFlashAttribute("msg", "Dish added successfully!");
                dish.setCategory(categoryService.findCategoryByTitle(dish.getCategory().getCategoryTitle()));
                dish.setIngredients(fixedSelectedIngredients(dish.getIngredients()));
                dishService.createDish(dish);

            } else {
                redirectAttributes.addFlashAttribute("msg", "Dish updated successfully!");
                dishService.updateDishTitle(dish.getId(), dish.getDishTitle());
                dishService.updateDishCategoryId(dish.getId(),
                        categoryService.findCategoryByTitle(dish.getCategory().getCategoryTitle()));
                dishService.updateDishPrice(dish.getId(), dish.getPrice());
                dishService.updateDishWeight(dish.getId(), dish.getWeight());

                dishService.updateDistIngredients(dish.getId(), fixedSelectedIngredients(dish.getIngredients()));
            }

            return "redirect:/dishes/" + dish.getId();
        }

    }

    private List<Ingredient> fixedSelectedIngredients(List<Ingredient> ingredients) {
        List<Ingredient> ingredientsList = new ArrayList<>();
        for (Ingredient currentIngredient : ingredients) {
            ingredientsList.add(ingredientService.findIngredientByTitle(currentIngredient.getIngredientTitle()));
        }
        return ingredientsList;
    }
}
