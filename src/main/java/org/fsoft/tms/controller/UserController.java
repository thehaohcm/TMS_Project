package org.fsoft.tms.controller;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
