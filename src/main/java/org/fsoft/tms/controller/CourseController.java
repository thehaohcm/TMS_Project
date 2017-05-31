package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.service.CategoryService;
import org.fsoft.tms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/addStaff")
    public String addStaff() {
        course.addTrainees();
        return "redirect:/staff/course/";
    }
}
