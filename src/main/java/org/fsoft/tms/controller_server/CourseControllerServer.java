package org.fsoft.tms.controller_server;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.service.ServiceCategory;
import org.fsoft.tms.service.ServiceCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/24/2017.
 */
@Controller
@RequestMapping(value = "/tms/server/course")
public class CourseControllerServer {
    @Autowired
    private ServiceCourse course;

    @Autowired
    private ServiceCategory category;

    @RequestMapping(value = "/getall")
    public String getAllCourse(Model model) {
        model.addAttribute("listCourse", course.getAllCourse());
        return "course";
    }

    @RequestMapping(value = "/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("listCategory", category.getListCategory());
        return "addcourse";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCourse(@PathVariable String id, Model model) {
        Course c = course.findOneCourse(Integer.parseInt(id));
        model.addAttribute("course", c);
        model.addAttribute("listCategory", category.getListCategory());
        return "updateCourse";
    }

    @RequestMapping(value = "/update")
    public String updateCourse(@ModelAttribute Course c) {
        course.updateCourse(c);
        return "redirect:/tms/server/course/getall";
    }
}
