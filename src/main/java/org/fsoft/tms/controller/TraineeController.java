package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.Property;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
//        List<User> users = userService.getAllUserByRole(4);
//        List<TraineeInfo> traineeInfos=new List<TraineeInfo>();
//        for(User user:users){
//            traineeInfos.add(new TraineeInfo(userPropertyService.getUserProperty(user,)));
//        }
        model.addAttribute("trainee", new TraineeInfo());
        model.addAttribute("listTrainee",userService.getAllUserByRole(4));
        return "trainee/index";
    }

    @RequestMapping(value="/profile/{id}")
    public String getPageProfile(@PathVariable String id, Model model){
        User user=userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user",user);
        return "trainee/profile";
    }

    @RequestMapping(value="/add")
    public String getPageUpdate(Model model){
        model.addAttribute("user",new User());
        return "trainee/add";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteTrainee(@PathVariable String id){
        User user=userService.findOneUser(Integer.parseInt(id));
        user.setActive(false);
        userService.saveUser(user);
        return "/staff/trainee/";
    }

}
