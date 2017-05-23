package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.repository.PropertyRepository;
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
@RequestMapping(value="/tms/property")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping("/getall")
    public List<Property> getAllPermission(){
        return propertyRepository.findAll();
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addProperty(@RequestBody Property property){
        if(property==null)
            return false;
        try {
            propertyRepository.save(property);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public boolean editProperty(@RequestBody Property property){
        if(property==null)
            return false;
        try {
            propertyRepository.save(property);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeProperty(@RequestBody Property property){
        if(property==null)
            return false;
        try {
            propertyRepository.save(property);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
