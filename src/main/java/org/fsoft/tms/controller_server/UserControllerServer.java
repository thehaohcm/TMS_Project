package org.fsoft.tms.controller_server;

import org.fsoft.tms.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/23/2017.
 */
@Controller
@RequestMapping(value = "/tms/server/user")
public class UserControllerServer {
    @Autowired
    ServiceUser user;

    @RequestMapping(value = "/getall")
    public String getListUser(Model model) {
        model.addAttribute("listUser", user.getListUser());
        return "them";
    }
}
