package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.TopicRepository;
import org.fsoft.tms.service.CourseService;
import org.fsoft.tms.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/27/2017.
 */
@Controller
@RequestMapping(value = "/staff/topic")
public class TopicController {

    @Autowired
    CourseService courseService;

    @Autowired
    TopicService topicService;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listTopic", topicService.getAllTopicByStaff());
        return "topic/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAdd(Model model) {
        model.addAttribute("topic", new Topic());
        model.addAttribute("listCourse", courseService.getAllCourseByStaff());
        return "topic/add";
    }

    @RequestMapping(value = "/addTopic")
    public String getPageAdd(@ModelAttribute Topic topic) {
        topic.setActive(true);
        topicService.addTopic(topic);
        return "redirect:/staff/topic/";
    }

    @RequestMapping(value = "/update/{id}")
    public String getPageAdd(@PathVariable String id, Model model) {
        Topic topic = topicService.finOneById(Integer.parseInt(id));
        model.addAttribute("topic", topic);
        return "topic/update";
    }

    @RequestMapping(value = "/updateTopic")
    public String update(@ModelAttribute Topic topic) {
        topicService.updateTopic(topic);
        return "redirect:/staff/topic/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String getPageDelete(@PathVariable String id) {
        topicService.deleteTopic(Integer.parseInt(id));
        return "redirect:/staff/topic/";
    }
}
