package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/getall")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping("/user/course")
    public Set<Course> getUserCouse(){
        return userRepository.findOne(4).getUsercourses();
        //return userRepository.findAll()
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user){
        if(user==null)
            return false;
        try {
            userRepository.save(user);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public boolean editUser(@RequestBody User user){
        if(user==null)
            return false;
        try {
            userRepository.save(user);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeUser(@RequestBody User user){
        if(user==null)
            return false;
        try {
            userRepository.save(user);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
