package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.TrainerInfo;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
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
import java.util.Set;

/**
 * Created by Isabella on 30-May-2017.
 */
@Controller
@RequestMapping(value = "/trainer")
public class TrainersController {

    private final Logger logger = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private UserPropertyService userPropertyService;

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/profile")
    public String getPageProfile(Model model) {
        User user = CurrentUser.getInstance().getUser();
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
        return "trainer/profile";
    }

    @RequestMapping(value = "/updateProfile")
    public String UpdateProfile(@ModelAttribute TrainerInfo trainerInfo) {

        userService.saveTrainer(trainerInfo);

        Set<UserProperty> userProperties = new HashSet<>(0);

        logger.debug("-1:"+trainerInfo.getName());

        userProperties = userService.setTrainerProperty(trainerInfo.getUser(), trainerInfo.getName(),
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

        //userService.saveUser(user);
        return "redirect:/";
    }
}
