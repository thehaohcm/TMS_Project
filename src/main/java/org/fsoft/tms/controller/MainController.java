package org.fsoft.tms.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DELL on 5/26/2017.
 */
@Controller
//@RequestMapping(value = "/tms")
public class MainController {
//    @RequestMapping(value = "/login")
//    public String login() {
//        return "/categories/index";
//    }

    @GetMapping("/")
    public String index() {
        return "index1";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/staff")
    public String staff() {
        return "admin";
    }

    @GetMapping("/trainer")
    public String trainer() {
        return "admin";
    }

    @GetMapping("/trainee")
    public String trainee() {
        return "admin";
    }

    @GetMapping("/admin/a")
    public String admina() {
        return "admin";
    }

    @GetMapping("/staff/a")
    public String staffa() {
        return "admin";
    }

    @GetMapping("/trainer/a")
    public String trainera() {
        return "admin";
    }

    @GetMapping("/trainee/a")
    public String traineea() {
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login1";
    }

    @GetMapping("/lg")
    public String login(){
        return "index1";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

}
