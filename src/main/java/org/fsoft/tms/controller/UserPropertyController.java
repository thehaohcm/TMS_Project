package org.fsoft.tms.controller;

import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.entity.UserPropertyKey;
import org.fsoft.tms.repository.PropertyRepository;
import org.fsoft.tms.repository.UserPropertyRepository;
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
public class UserPropertyController {

    @Autowired
    private UserPropertyRepository userPropertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping("/userproperty/getone")
    public UserProperty getUserProperty(){
//        return userPropertyRepository.findOne(new UserPropertyKey(userRepository.getOne(4), propertyRepository));
//        return userPropertyRepository.getOne();
        return userPropertyRepository.findOne(new UserPropertyKey(userRepository.findOne(4), propertyRepository.findOne(6)));
//        return userPropertyRepository.findAll();
    }

    @RequestMapping("/userproperty/getproperty")
    public List<UserProperty> getUserProperties(){
//        return userPropertyRepository.findOne(new UserPropertyKey(userRepository.getOne(4), propertyRepository));
//        return userPropertyRepository.getOne();
        return userPropertyRepository.findAllByUser(userRepository.findOne(4));
//        return userPropertyRepository.findAll();
    }

    @RequestMapping("/userproperty/getall")
    public List<UserProperty> getAllUserProperty(){
        return userPropertyRepository.findAll();
    }
}
