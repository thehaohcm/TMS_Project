package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.CurrentUser;
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

import java.sql.Date;
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
        model.addAttribute("listTrainee",userService.getAllUserByRole(4));
        return "trainee/index";
    }

    @RequestMapping(value="/profile/{id}")
    public String getPageProfile(@PathVariable String id, Model model){
        User user=userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("trainee",user);
        return "trainee/profile";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageUpdate(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        TraineeInfo traineeInfo = new TraineeInfo();
        traineeInfo.setUser(user);
        traineeInfo.setName(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(1)).getValue());
        traineeInfo.setBirthDate(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(2)).getValue());
        traineeInfo.setEducation(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(3)).getValue());
        traineeInfo.setProgrammingLanguage(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(4)).getValue());
        traineeInfo.setToeicScore(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(5)).getValue());
        traineeInfo.setExperienceDetail(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(6)).getValue());
        traineeInfo.setDepartment(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(7)).getValue());
        traineeInfo.setLocation(userPropertyService.getUserProperty(user,
                propertyService.findOneProperty(12)).getValue());
        model.addAttribute("trainee", traineeInfo);
        return "trainee/update";
    }

    @RequestMapping(value="/updateProfile")
    public String updateProfile(@ModelAttribute TraineeInfo traineeInfo){
        userService.saveTrainee(traineeInfo);
        return "redirect:/staff/trainee/";
    }

    @RequestMapping(value="/add")
    public String getPageAdd(Model model){
        User user =new User();
        TraineeInfo traineeInfo=new TraineeInfo();
        traineeInfo.setUser(user);
        model.addAttribute("trainee",traineeInfo);
        return "trainee/add";
    }

    @RequestMapping(value="/addTrainee")
    public String addTrainee(@ModelAttribute TraineeInfo traineeInfo){
        logger.debug("ID user instance: "+CurrentUser.getInstance().getUser().getUsername()+" "+CurrentUser.getInstance().getUser().getId());
        userService.addTrainee(traineeInfo.getUser(), CurrentUser.getInstance().getUser().getId());
        return "redirect:/staff/trainee/";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteTrainee(@PathVariable String id){
        User user=userService.findOneUser(Integer.parseInt(id));
        user.setActive(false);
        userService.saveUser(user);
        return "redirect:/staff/trainee/";
    }

    @RequestMapping(value="/recover/{id}")
    public String recoverTrainee(@PathVariable String id){
        User user=userService.findOneUser(Integer.parseInt(id));
        user.setActive(true);
        userService.saveUser(user);
        return "redirect:/staff/trainee/";
    }
}
