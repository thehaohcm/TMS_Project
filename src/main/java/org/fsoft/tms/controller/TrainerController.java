package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.*;
import org.fsoft.tms.repository.RoleRepository;
import org.fsoft.tms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DELL on 5/27/2017.
 */
@Controller
@RequestMapping(value = "/tms/trainer")
public class TrainerController
{
    @Autowired
    UserService userService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    UserPropertyService userPropertyService;

    @Autowired
    TopicService topicService;

    private final Logger logger = LogManager.getLogger();

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listUser", userService.getAllUserByRole(3));
        return "trainer/index";
    }

    @RequestMapping(value = "/profile/{id}")
    public String getPageProfile(@PathVariable String id, Model model) {
        User user = userService.findOneUser(Integer.parseInt(id));
        model.addAttribute("user", user);
        return "trainer/profile";
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
//        model.addAttribute("listUserProperty", userPropertyService.getListUserProperty(user));
        return "trainer/update";
    }

    @RequestMapping(value = "/updateProfile")
    public String Update(@ModelAttribute TrainerInfo trainerInfo) {
        logger.debug(trainerInfo.getUser().getUsername());

        Set<UserProperty> userProperties = new HashSet<>(0);

        logger.debug("-1:"+trainerInfo.getName());

        userProperties = userPropertyService.setTrainerProperty(trainerInfo.getUser(), trainerInfo.getName(),
                trainerInfo.getEmail(), trainerInfo.getPhone(), trainerInfo.getAddress());
        for(UserProperty userProperty : userProperties)
            logger.debug("0:"+userProperty.getValue());

        User user = userService.findOneUser(trainerInfo.getUser().getId());
        user.setUserProperties(userProperties);
        logger.debug("1:"+user.getUsername());
        logger.debug("2:"+user.getPassword());
        Set<UserProperty> userProperties1 = user.getUserProperties();
        for(UserProperty userProperty : userProperties1)
            logger.debug("3:"+userProperty.getValue());
//        logger.debug("4:"+user.getManager().toString());

        userService.saveUser(user);
        return "redirect:/tms/trainer/";
    }

//    @RequestMapping(value = "/update/{id}")
//    public String getPageUpdate(@PathVariable String id, Model model) {
//        User user = userService.findOneUser(Integer.parseInt(id));
////        TrainerInfo trainerInfo = new TrainerInfo();
////        trainerInfo.setUser(user);
////        trainerInfo.setName(userPropertyService.getUserProperty(user,
////                propertyService.findOneProperty(1)).getValue());
////        trainerInfo.setEmail(userPropertyService.getUserProperty(user,
////                propertyService.findOneProperty(10)).getValue());
////        trainerInfo.setPhone(userPropertyService.getUserProperty(user,
////                propertyService.findOneProperty(9)).getValue());
////        trainerInfo.setAddress(userPropertyService.getUserProperty(user,
////                propertyService.findOneProperty(8)).getValue());
//        model.addAttribute("nameProperty", userPropertyService.getUserProperty(user,
//                propertyService.findOneProperty(1)));
//        model.addAttribute("emailProperty", userPropertyService.getUserProperty(user,
//                propertyService.findOneProperty(10)));
//        model.addAttribute("phoneProperty", userPropertyService.getUserProperty(user,
//                propertyService.findOneProperty(9)));
//        model.addAttribute("addressProperty", userPropertyService.getUserProperty(user,
//                propertyService.findOneProperty(10)));
//        return "trainer/update";
//    }
//
//    @RequestMapping(value = "/updateProfile")
//    public String Update(@ModelAttribute UserProperty name, UserProperty email, UserProperty phone, UserProperty address) {
//        logger.debug("1:"+name.getValue());
//        logger.debug("2:"+email.getValue());
//        logger.debug("3:"+phone.getValue());
//        logger.debug("4:"+address.getValue());
//        List<UserProperty> userProperties = new ArrayList<>();
//        userProperties.add(name);
//        userProperties.add(email);
//        userProperties.add(phone);
//        userProperties.add(address);
//        userPropertyService.saveTrainerProperty(userProperties);
//        return "redirect:/tms/trainer/";
//    }


    @RequestMapping(value = "/topic")
    public String getListTopic(Model model) {
        CurrentUser currentUser = CurrentUser.getInstance();
        model.addAttribute("course", new Course());
        model.addAttribute("listCourse", topicService.findAllCourseOfUser(currentUser.getUser()));
        model.addAttribute("listTopic", topicService.getAllTopic());
        return "coursetopic";
    }

    @RequestMapping(value = "/course")
    public String getListTopicCourse(Model model) {
        CurrentUser currentUser = CurrentUser.getInstance();
        model.addAttribute("user",currentUser.getUser());
        model.addAttribute("listCourse", topicService.findAllCourseOfUser(currentUser.getUser()));
        return "course";
    }


}
