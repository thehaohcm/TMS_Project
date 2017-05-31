package org.fsoft.tms.controller;

import org.fsoft.tms.entity.TrainerInfo;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Isabella on 31-May-2017.
 */
@Controller
@RequestMapping(value = "/admin/trainer")
public class TrainerAccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listUser", userService.getAllUserByRole(3));
        return "trainerAccount/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCategory(Model model) {
        model.addAttribute("trainer", new TrainerInfo());
        return "trainerAccount/add";
    }

    @RequestMapping(value = "/addAccount")
    public String addAccount (@ModelAttribute  TrainerInfo trainerInfo) {

        userService.addUser(trainerInfo.getUser(), 3);
        return "redirect:/admin/trainer/";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageUpdate(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "trainerAccount/update";
    }

    @RequestMapping(value = "/update")
    public String updateAccount (@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin/trainer/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteAccount(@PathVariable String id, Model model) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/admin/trainer/";
    }

}
