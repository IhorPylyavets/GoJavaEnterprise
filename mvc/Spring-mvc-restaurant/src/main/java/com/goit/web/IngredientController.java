package com.goit.web;

import com.goit.model.Ingredient;
import com.goit.service.IngredientService;
import com.goit.web.validators.IngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    private IngredientValidator ingredientValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(ingredientValidator);
    }

    @Autowired
    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public String showAllIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredient());
        return "ingredients/list_ingredients";
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
    public String showIngredient(@PathVariable("id") int id, Model model) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        if (ingredient == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Ingredient not found");
        }
        model.addAttribute("ingredient", ingredient);
        return "ingredients/show";
    }

    @RequestMapping(value = "/ingredients/{id}/delete", method = RequestMethod.POST)
    public String deleteIngredient(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        ingredientService.deleteIngredient(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Ingredient is deleted!");

        return "redirect:/ingredients";
    }

    @RequestMapping(value = "/ingredients/{id}/update", method = RequestMethod.GET)
    public String showUpdateIngredientForm(@PathVariable("id") int id, Model model) {
        Ingredient ingredient = ingredientService.findIngredientById(id);
        model.addAttribute("ingredient_form", ingredient);

        return "ingredients/ingredient_form";
    }

    @RequestMapping(value = "/ingredients/create", method = RequestMethod.GET)
    public String showCreateIngredientForm(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient_form", ingredient);

        return "ingredients/ingredient_form";
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    public String saveOrUpdateIngredient(@ModelAttribute("ingredient_form") @Validated Ingredient ingredient,
                                         BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "ingredients/ingredient_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(ingredient.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Ingredient added successfully!");
                ingredientService.createIngredient(ingredient);
            }else{
                redirectAttributes.addFlashAttribute("msg", "Ingredient updated successfully!");
                ingredientService.updateIngredientTitle(ingredient.getId(), ingredient.getIngredientTitle());
            }

            return "redirect:/ingredients/" + ingredient.getId();
        }

    }
}
