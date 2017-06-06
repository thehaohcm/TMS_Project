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
        User user_temp=new User();
        user_temp.setId(user.getId());
        user_temp.setUsername(user.getUsername());
        user_temp.setPassword(user.getPassword());
        model.addAttribute("user", user);
        return "staffaccount/update";
    }

    @RequestMapping(value = "/update")
    public String updateAccount (@ModelAttribute User user) {
        User user1=userService.findOneUser(user.getId());
        String encrypt_pass= userService.encode(user.getPassword());
        if(!user.getPassword().trim().equals("")&&!user1.getPassword().equals(encrypt_pass))
            userService.updateUser(user,true);
        userService.updateUser(user,false);
        return "redirect:/admin/staff/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteAccount(@PathVariable String id, Model model) {
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/admin/staff/";
    }
    @RequestMapping(value = "/recover/{id}")
    public String recoverAccount(@PathVariable String id, Model model) {
        userService.recoverUser(Integer.parseInt(id));
        return "redirect:/admin/staff/";
    }
}

