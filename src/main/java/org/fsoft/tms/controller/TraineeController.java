package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.TraineeInfo;
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
 * Created by thehaohcm on 5/30/17.
 */
@Controller
@RequestMapping(value="/staff/trainee")
public class TraineeController {

    @Autowired
    UserService userService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    UserPropertyService userPropertyService;

    private final Logger logger = LogManager.getLogger();

    @RequestMapping(value="/")
    public String getPageIndex(Model model){
        model.addAttribute("trainee", new TraineeInfo());
        model.addAttribute("listTrainee",userService.getAllUserByRole(4));
        return "traineeProfile/index";
    }

    @RequestMapping(value="/profile/{id}")
    public String getPageProfile(@PathVariable String id, Model model){
        User user=userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user",user);
        return "traineeProfile/profile";
    }

    @RequestMapping(value="/add")
    public String getPageUpdate(Model model){
        model.addAttribute("user",new User());
        return "trainee/add";
    }

//    @RequestMapping(value="/addTrainee")
//    public String addTrainee(@ModelAttribute TraineeInfo traineeInfo){
//
//    }

}
