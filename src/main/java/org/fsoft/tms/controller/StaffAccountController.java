package org.fsoft.tms.controller;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.UserService;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/31/2017.
 */
@Controller
@RequestMapping(value = "/admin/staff")
public class StaffAccountController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listUser", userService.getAllUserByRole(2));
        return "staffaccount/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAdd(Model model) {
        model.addAttribute("user", new User());
        return "staffaccount/add";
    }

    @RequestMapping(value = "/addAccount")
    public String addAccount (@ModelAttribute  User user) {
        userService.addUser(user, 2,1);
        return "redirect:/admin/staff/";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageUpdate(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "staffaccount/update";
    }

    @RequestMapping(value = "/update")
    public String updateAccount (@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/admin/staff/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteAccount(@PathVariable String id, Model model) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/admin/staff/";
    }
}

