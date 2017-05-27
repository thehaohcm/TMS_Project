package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Role;
import org.fsoft.tms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DELL on 5/26/2017.
 */
@Controller
//@RequestMapping(value = "/tms")
public class LoginController {
//    @RequestMapping(value = "/login")
//    public String login() {
//        return "/categories/index";
//    }

    @Autowired
    LoginService loginService;


    @RequestMapping("/")
    public String index() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String name=auth.getName();
            Role role=loginService.getRoleByUser(name);

            switch(role.getName()){
                case "ROLE_ADMIN":
                    return "indexadmin";
                case "ROLE_TS":
                    return "indextrainningstaff";
                case "ROLE_TER":
                    return "admin";
                case "ROLE_TEE":
                    return "index1";
            }

        }
        return "index1";

    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login1";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }


}
