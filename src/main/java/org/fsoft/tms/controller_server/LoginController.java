package org.fsoft.tms.controller_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/23/2017.
 */
@Controller
@RequestMapping(value = "/tms")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
