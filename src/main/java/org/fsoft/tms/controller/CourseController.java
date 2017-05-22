package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/course/getall")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
}
