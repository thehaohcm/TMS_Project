package org.fsoft.tms.service_impl;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.repository.PropertyRepository;
import org.fsoft.tms.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class PropertyServiceImpl implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public void addProperty(Property role) {
        propertyRepository.save(role);
    }

    @Override
    public Property findOneProperty(int id) {
        return propertyRepository.findOne(id);
    }

    @Override
    public void updateProperty(Property c) {
        Property temp = propertyRepository.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        propertyRepository.save(temp);
    }
}
