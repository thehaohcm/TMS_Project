package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.service.CategoryService;
import org.fsoft.tms.service.CourseService;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Controller
@RequestMapping(value = "/staff/course")
public class CourseController {
    @Autowired
    private CourseService course;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService category;

    @RequestMapping(value = "/")
    public String getPageIndex(Model model) {
        model.addAttribute("listCourse", course.getAllCourseByStaff());
        return "course/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("listCategory", category.getListCategory());
        return "course/add";
    }

    @RequestMapping(value = "/trainee/{id}")
    public String getListTrainee(@PathVariable String id, Model model) {
        Course c = course.findOneCourse(Integer.parseInt(id));
        model.addAttribute("course", c);
        model.addAttribute("listTrainee", userService.getListTraineeNonCourse(Integer.parseInt(id)));
        return "course/trainee";
    }

    @RequestMapping(value = "/trainee/{traineeID}/{courseID}")
    public String addTraineeToCourse(@PathVariable("traineeID") String traineeID, @PathVariable("courseID") String courseID, Model model) {
        course.addTrainees(Integer.parseInt(courseID), Integer.parseInt(traineeID));
        return "redirect:/staff/course/trainee/{courseID}";
    }

    @RequestMapping(value = "/listtrainee/{id}")
    public String getListTraineeCourse(@PathVariable String id, Model model) {
        model.addAttribute("listTrainee", userService.getListTraineeCourse(Integer.parseInt(id)));
        return "course/listtrainee";
    }


    @RequestMapping(value = "/addCourse")
    public String addCourse(@ModelAttribute Course c) {
        course.addCourse(c);
        return "redirect:/staff/course/";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCourse(@PathVariable String id, Model model) {
        Course c = course.findOneCourse(Integer.parseInt(id));
        model.addAttribute("course", c);
        model.addAttribute("listCategory", category.getListCategoryActive());
        return "course/update";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCourse(@PathVariable String id) {
        course.deleteCourse(Integer.parseInt(id));
        return "redirect:/staff/course/";
    }

    @RequestMapping(value = "/updateCourse")
    public String updateCourse(@ModelAttribute Course c) {
        course.updateCourse(c);
        return "redirect:/staff/course/";
    }

    @RequestMapping(value="/search")
    public String searchCourse(@RequestParam("q") String q, Model model){
        if(q.equals(""))
            return "redirect:/staff/course/";
        model.addAttribute("listCourse",course.searchCourse(q));
        return "course/index";
    }
}
