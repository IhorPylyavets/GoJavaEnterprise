package com.goit.web;

import com.goit.model.Desk;
import com.goit.model.DeskStatus;
import com.goit.service.DeskService;
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

import java.util.Arrays;

@Controller
public class DeskController {

    private DeskService deskService;

    @Autowired
    public void setDeskService(DeskService deskService) {
        this.deskService = deskService;
    }

    @RequestMapping(value = "/desks", method = RequestMethod.GET)
    public String showAllDesks(Model model) {
        model.addAttribute("desks", deskService.getAll());
        return "desks/list_desks";
    }

    @RequestMapping(value = "/desks/{id}", method = RequestMethod.GET)
    public String showDesk(@PathVariable("id") int id, Model model) {
        Desk desk = deskService.findById(id);
        if (desk == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Desk not found");
        }
        model.addAttribute("desk", desk);
        return "desks/show";
    }

    @RequestMapping(value = "/desks/{id}/delete", method = RequestMethod.POST)
    public String deleteDesk(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        deskService.delete(id);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Desk is deleted!");

        return "redirect:/desks";
    }

    @RequestMapping(value = "/desks/{id}/update", method = RequestMethod.GET)
    public String showUpdateDeskForm(@PathVariable("id") int id, Model model) {
        Desk desk = deskService.findById(id);
        model.addAttribute("desk_form", desk);
        model.addAttribute("statusList", Arrays.asList(DeskStatus.values()));

        return "desks/desk_form";
    }

    @RequestMapping(value = "/desks/create", method = RequestMethod.GET)
    public String showCreateDeskForm(Model model) {
        Desk desk = new Desk();
        model.addAttribute("desk_form", desk);
        model.addAttribute("statusList", Arrays.asList(DeskStatus.values()));

        return "desks/desk_form";
    }

    @RequestMapping(value = "/desks", method = RequestMethod.POST)
    public String saveOrUpdateDesk(@ModelAttribute("desk_form") @Validated Desk desk,
                                       BindingResult result, final RedirectAttributes redirectAttributes) {



        if (result.hasErrors()) {
            return "desks/desk_form";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(desk.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Desk added successfully!");
                System.out.println(desk);

                desk.setDeskStatus(DeskStatus.FREE);

                System.out.println(desk);
                deskService.create(desk);

            }else{
                redirectAttributes.addFlashAttribute("msg", "Desk updated successfully!");
                deskService.updateTitle(desk.getId(), desk.getDeskTitle());
                deskService.updateStatus(desk.getId(), desk.getDeskStatus());
            }

            return "redirect:/desks/" + desk.getId();
        }

    }

}
