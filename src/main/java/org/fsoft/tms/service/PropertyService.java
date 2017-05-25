package org.fsoft.tms.service;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class PropertyService {
    @Autowired
    PropertyRepository service;

    public List<Property> getAllProperty() {
        return service.findAll();
    }

    public void addProperty(Property role) {
        service.save(role);
    }

    public Property findOneProperty(int id) {
        return service.findOne(id);
    }

    public void updateProperty(Property c) {
        Property temp = service.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        service.save(temp);
    }
}
