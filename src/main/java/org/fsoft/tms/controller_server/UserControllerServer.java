package org.fsoft.tms.controller_server;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.ServiceRole;
import org.fsoft.tms.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/23/2017.
 */
@Controller
@RequestMapping(value = "/tms")
public class UserControllerServer {
    @Autowired
    ServiceUser user;

    @Autowired
    ServiceRole role;


    @RequestMapping(value = "/getall")
    public String getListUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listRole", role.listRole());
        model.addAttribute("listUser", user.getListUser());
        return "them";
    }

    @RequestMapping(value = "/add")
    public String addUser(@ModelAttribute User u) {
        user.addAccount(u);
        return "redirect:/tms/getall";
    }
}
