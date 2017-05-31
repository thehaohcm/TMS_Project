package org.fsoft.tms.controller;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Isabella on 31-May-2017.
 */
@Controller
@RequestMapping(value = "/admin/trainer")
public class TrainerAccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listUser", userService.getAllUserByRole(3));
        return "trainerAccount/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCategory(Model model) {
        model.addAttribute("trainer", new User());
        return "trainerAccount/add";
    }

    @RequestMapping(value = "/addAccount")
    public String addCategory(@ModelAttribute User user) {
        user.setActive(true);
        userService.addUser(user);
        return "redirect:/staff/category/";
    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public String deleteCatogory(@PathVariable String id) {
//        logger.debug("vao rui");
//        category.deleteCategory(Integer.parseInt(id));
//        return "redirect:/staff/category/";
//    }
//
//    @RequestMapping(value = "/update/{id}")
//    public String updateCategory(@PathVariable String id, Model model) {
//        Category cat = category.findOneCategory(Integer.parseInt(id));
//        model.addAttribute("category", cat);
//        return "category/update";
//    }
//
//    @RequestMapping(value = "/update")
//    public String updateCatogory(@ModelAttribute Category cat) {
//        category.updateCategory(cat);
//        return "redirect:/staff/category/";
//    }
}
