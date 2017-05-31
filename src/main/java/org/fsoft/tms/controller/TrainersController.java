package org.fsoft.tms.controller;

import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Isabella on 30-May-2017.
 */
@Controller
@RequestMapping(value = "/trainer")
public class TrainersController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile")
    public String getPageProfile(@PathVariable String id, Model model) {
        User user = CurrentUser.getInstance().getUser();
        model.addAttribute("user", user);
        return "trainerProfile/profile";
    }
}
