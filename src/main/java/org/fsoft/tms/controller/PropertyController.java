package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */

@RestController
@RequestMapping(value="/tms")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @RequestMapping("/property/getall")
    public List<Property> getAllPermission(){
        return propertyRepository.findAll();
    }
}
