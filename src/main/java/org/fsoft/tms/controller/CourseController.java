package org.fsoft.tms.controller;

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

    @RequestMapping(value = "/index")
    public String getPageIndex(Model model) {
        model.addAttribute("listCourse", course.getAllCourse());
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
        c.setActive(true);
        course.addCourse(c);
        return "redirect:/tms/course/index";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCourse(@PathVariable String id, Model model) {
        Course c = course.findOneCourse(Integer.parseInt(id));
        model.addAttribute("course", c);
        model.addAttribute("listCategory", category.getListCategory());
        return "course/update";
    }

    @RequestMapping(value = "/updateCourse")
    public String updateCourse(@ModelAttribute Course c) {
        course.updateCourse(c);
        return "redirect:/tms/course/index";
    }

    @RequestMapping(value = "/addStaff")
    public String addStaff() {
        course.addTrainees();
        return "redirect:/tms/course/index";
    }
}
