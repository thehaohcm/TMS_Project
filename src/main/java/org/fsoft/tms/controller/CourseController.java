package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CourseService;
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
@RequestMapping(value = "/demo/server/course")
public class CourseController {
    @Autowired
    private CourseService course;

    @Autowired
    private CategoryService category;

    @RequestMapping(value = "/getall")
    public String getAllCourse(Model model) {
        model.addAttribute("listCourse", course.getAllCourse());
        return "course";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("listCategory", category.getListCategory());
        return "addcourse";
    }

    @RequestMapping(value = "/addCourse")
    public String addCourse(@ModelAttribute Course c) {
        c.setActive(true);
        course.addCourse(c);
        return "redirect:/demo/server/course/getall";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCourse(@PathVariable String id, Model model) {
        Course c = course.findOneCourse(Integer.parseInt(id));
        model.addAttribute("course", c);
        model.addAttribute("listCategory", category.getListCategory());
        return "updateCourse";
    }

    @RequestMapping(value = "/updateCourse")
    public String updateCourse(@ModelAttribute Course c) {
        course.updateCourse(c);
        return "redirect:/demo/server/course/getall";
    }

    @RequestMapping(value = "/addStaff")
    public String addStaff() {
        course.addTrainees();
        return "redirect:/demo/server/course/getall";
    }
}
