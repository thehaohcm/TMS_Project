package org.fsoft.tms.controller;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        userService.saveUser(user);
        return "redirect:/admin/staff/";
    }
}

