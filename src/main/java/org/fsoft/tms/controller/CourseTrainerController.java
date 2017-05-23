package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.CourseTrainer;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.CourseTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/coursetrainer")
public class CourseTrainerController {
    @Autowired
    private CourseTrainerRepository courseTrainerRepository;

    @RequestMapping("/getall")
    public List<CourseTrainer> getAllCourseTrainer(){
        return courseTrainerRepository.findAll();
    }

    @RequestMapping(value="/addCourseTrainer/",method = RequestMethod.POST)
    public boolean addTrainerToCourse(@PathVariable User user,@PathVariable Course course){
        if(user==null || course==null)
            return false;
        try {
            CourseTrainer courseTrainer = new CourseTrainer();
            courseTrainer.setCoursetraineruser(user);
            courseTrainer.setCoursetrainercouse(course);
            courseTrainerRepository.save(courseTrainer);
        }catch (Exception ex){
            return false;
        }
        return true;

    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addCourseTrainer(@RequestBody CourseTrainer courseTrainer){
        if(courseTrainer==null)
            return false;
        try {
            courseTrainerRepository.save(courseTrainer);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public boolean editCourseTrainer(@RequestBody CourseTrainer courseTrainer){
        if(courseTrainer==null)
            return false;
        try {
            courseTrainerRepository.save(courseTrainer);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeCourseTrainer(@RequestBody CourseTrainer courseTrainer){
        if(courseTrainer==null)
            return false;
        try {
            courseTrainerRepository.delete(courseTrainer);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
