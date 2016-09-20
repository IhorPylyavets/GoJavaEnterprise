package com.goit.web;

import com.goit.model.Category;
import com.goit.service.CategoryService;
import com.goit.web.validators.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    private CategoryValidator categoryValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(categoryValidator);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories/list_categories";
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public String showCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findCategoryById(id);
        if (category == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Category not found");
        }
        model.addAttribute("category", category);
        return "categories/show";
    }

    @RequestMapping(value = "/categories/{id}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Category is deleted!");

        return "redirect:/categories";
    }

    @RequestMapping(value = "/categories/{id}/update", method = RequestMethod.GET)
    public String showUpdateCategoryForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category_form", category);

        return "categories/category_form";
    }

    @RequestMapping(value = "/categories/create", method = RequestMethod.GET)
    public String showCreateCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category_form", category);

        return "categories/category_form";
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String saveOrUpdateCategory(@ModelAttribute("category_form") @Validated Category category,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "categories/category_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(category.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Category added successfully!");

                System.out.println(category);
                categoryService.createCategory(category);
            }else{
                redirectAttributes.addFlashAttribute("msg", "Category updated successfully!");
                categoryService.updateCategoryTitle(category.getId(), category.getCategoryTitle());
            }

            return "redirect:/categories/" + category.getId();
        }

    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
