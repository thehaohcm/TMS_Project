package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.Role;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.RoleRepository;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by thehaohcm on 5/24/17.
 */
@RestController
public class MainController {

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/add")
    public boolean addRole(){
        try{
//            Role r=new Role();
//            r.setName("Trainer");
//
//            roleRepository.save(r);


        }catch (Exception ex)
        {
            return false;
        }
        return true;
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/addUserToCourse")
    public boolean addUserToCouse(){

        try {
            User user = userRepository.findOne(5);

            Course course = courseRepository.findOne(1);

            user.setUsercourses(courseRepository.findAllById(1));
        }catch (Exception ex){
            return false;
        }
        return true;
    }

}
