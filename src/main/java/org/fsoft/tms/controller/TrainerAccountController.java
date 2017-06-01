package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.TrainerInfo;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.PropertyService;
import org.fsoft.tms.service.UserPropertyService;
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

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private PropertyService propertyService;

    @Autowired
    private UserPropertyService userPropertyService;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listUser", userService.getAllUserByRole(3));
        return "trainerAccount/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCategory(Model model) {
        User user = new User();
        TrainerInfo trainerInfo = new TrainerInfo();
        trainerInfo.setUser(user);
        model.addAttribute("trainer", trainerInfo);
        return "trainerAccount/add";
    }

    @RequestMapping(value = "/addAccount")
    public String addAccount (@ModelAttribute  TrainerInfo trainerInfo) {
        userService.addUser(trainerInfo.getUser(), 3);
        userService.saveTrainer(trainerInfo);
        return "redirect:/admin/trainer/";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageUpdate(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        TrainerInfo trainerInfo = new TrainerInfo();
        trainerInfo.setUser(user);
        trainerInfo.setName(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(1)).getValue());
        trainerInfo.setEmail(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(10)).getValue());
        trainerInfo.setPhone(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(9)).getValue());
        trainerInfo.setAddress(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(8)).getValue());
        model.addAttribute("trainer", trainerInfo);
        return "trainerAccount/update";
    }

    @RequestMapping(value = "/update")
    public String updateAccount (@ModelAttribute TrainerInfo trainerInfo) {
        userService.updateUser(trainerInfo.getUser());
        userService.saveTrainer(trainerInfo);
        return "redirect:/admin/trainer/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteAccount(@PathVariable String id, Model model) {
        logger.debug("Id:" + id);
        userService.deleteUser(Integer.parseInt(id));
        return "redirect:/admin/trainer/";
    }

    @RequestMapping(value = "/account/{id}")
    public String getPageProfile(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "trainerAccount/profile";
    }
}
