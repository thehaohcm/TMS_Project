package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.*;
import org.fsoft.tms.service.*;
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
 * Created by Isabella on 30-May-2017.
 */
@Controller
@RequestMapping(value = "/trainer")
public class TrainersController {

    @Autowired
    UserService userService;

    @Autowired
    UserPropertyService userPropertyService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    TopicService topicService;

    @Autowired
    CourseService courseService;

    private final Logger logger = LogManager.getLogger();

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

        return "redirect:/";
    }

    @RequestMapping(value = "/topic")
    public String getListTopic(Model model) {
        CurrentUser currentUser = CurrentUser.getInstance();
        model.addAttribute("listTopic", topicService.findAllTopicByTrainer(currentUser.getUser()));
        return "trainer/topic";
    }

    @RequestMapping(value = "/course")
    public String getListCourse(Model model) {
        CurrentUser currentUser = CurrentUser.getInstance();
        model.addAttribute("listCourse", topicService.findAllCourseOfUser(currentUser.getUser()));
        return "trainer/course";
    }

    @RequestMapping(value = "/course/listTopic/{id}")
    public String getListTopicCourse(@PathVariable String id, Model model) {
        CurrentUser currentUser = CurrentUser.getInstance();
        Course course = courseService.findOneCourse(Integer.parseInt(id));
        List<Topic> arr= topicService.findAllTopicByCourse(currentUser.getUser(),course);
        model.addAttribute("listTopic", arr);
        return "trainer/coursetopic";
    }
}
