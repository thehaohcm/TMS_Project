package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thehaohcm on 5/23/17.
 */
@RestController
@RequestMapping("/tms")
public class Controller {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseTrainerRepository courseTrainerRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPropertyRepository userPropertyRepository;

//    @RequestMapping(value="/coursetrainee/add",method = RequestMethod.POST)
//    public boolean addCouserTrainee(@PathVariable Course course, @PathVariable User trainee){
//        if(course==null||trainee==null)
//            return false;
//        try{
//
//        }catch(Exception ex){
//            return false;
//        }
//        return true;
//    }

}
