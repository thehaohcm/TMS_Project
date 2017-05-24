package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.CourseTrainer;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.CourseTrainerRepository;
import org.fsoft.tms.repository.UserRepository;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/getall")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public User getInfobyID(@PathVariable Integer id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value="/searchByName/{name}",method=RequestMethod.GET)
    public User getInfoByName(@PathVariable String name){
        return (User) userRepository.findUserByUsername(name);
    }

    @RequestMapping("/course")
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
