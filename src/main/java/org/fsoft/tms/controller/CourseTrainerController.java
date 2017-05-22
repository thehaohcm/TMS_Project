package org.fsoft.tms.controller;

import org.fsoft.tms.entity.CourseTrainer;
import org.fsoft.tms.repository.CourseTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class CourseTrainerController {
    @Autowired
    private CourseTrainerRepository courseTrainerRepository;

    @RequestMapping("/coursetrainer/getall")
    public List<CourseTrainer> getAllCourse(){
        return courseTrainerRepository.findAll();
    }

}
