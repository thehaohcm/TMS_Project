package org.fsoft.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/26/2017.
 */
@Controller
@RequestMapping(value = "/tms")
public class MainController {
    @RequestMapping(value = "/login")
    public String login() {
        return "indexadmin";
    }

}
