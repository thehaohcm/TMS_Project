package org.fsoft.tms.controller;

import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.RoleRepository;
import org.fsoft.tms.service.RoleService;
import org.fsoft.tms.service.TopicService;
import org.fsoft.tms.service.UserPropertyService;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
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
    UserPropertyService userPropertyService;

    @Autowired
    TopicService topicService;

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
        model.addAttribute("user", user);
        model.addAttribute("listUserProperty", userPropertyService.getListUserProperty(user));
        return "trainer/update";
    }

    @RequestMapping(value = "/updateProfile")
    public String Update(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/tms/trainer/";
    }


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
