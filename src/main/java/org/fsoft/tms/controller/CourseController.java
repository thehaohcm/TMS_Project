package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/getall")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @RequestMapping(value="/add",method= RequestMethod.POST)
    public boolean addCourse(@RequestBody Course course){
        if(course==null)
            return false;
        try {
            courseRepository.save(course);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method=RequestMethod.POST)
    public boolean editCourse(@RequestBody Course course){
        if(course==null)
            return false;
        try {
            courseRepository.save(course);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeCourse(@RequestBody Course course){
        if(course==null)
            return false;
        try {
            courseRepository.delete(course);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
