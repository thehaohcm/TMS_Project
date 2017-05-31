package org.fsoft.tms.service.impl;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.PropertyRepository;
import org.fsoft.tms.repository.UserPropertyRepository;
import org.fsoft.tms.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/30/17.
 */
@Service
public class UserPropertyServiceImpl implements UserPropertyService {

    @Autowired
    private UserPropertyRepository userPropertyRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<UserProperty> getListUserProperty(User user) {
        return userPropertyRepository.getAllByPk_User(user);
    }

    @Override
    public UserProperty getUserProperty(User user, Property property) {
        return userPropertyRepository.getAllByPk_UserAndPk_Property(user, property);
    }

//    @Override
//    public Set<UserProperty> setTrainerProperty(User user, String name, String email, String phone, String address) {
//        UserProperty userProperty = new UserProperty();
//        Set<UserProperty> userProperties = new HashSet<>(0);
//        userProperty.setUser(user);
//        userProperty.setProperty(propertyRepository.findOne(1));
//        userProperty.setValue(name);
//        userProperties.add(userProperty);
//        userProperty = new UserProperty();
//        userProperty.setUser(user);
//        userProperty.setProperty(propertyRepository.findOne(10));
//        userProperty.setValue(email);
//        userProperties.add(userProperty);
//        userProperty = new UserProperty();
//        userProperty.setUser(user);
//        userProperty.setProperty(propertyRepository.findOne(9));
//        userProperty.setValue(phone);
//        userProperties.add(userProperty);
//        userProperty = new UserProperty();
//        userProperty.setUser(user);
//        userProperty.setProperty(propertyRepository.findOne(8));
//        userProperty.setValue(address);
//        userProperties.add(userProperty);
//        return userProperties;
//    }

    @Override
    public void saveTrainerProperty(List<UserProperty> userProperties) {
        userProperties.forEach((item)->{
            userPropertyRepository.save(item);
        });
    }
}
