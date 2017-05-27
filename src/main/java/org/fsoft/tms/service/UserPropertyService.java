package org.fsoft.tms.service;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.UserPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/27/2017.
 */
@Service
public class UserPropertyService {
    @Autowired
    UserPropertyRepository userProperty;

    public List<UserProperty> getListUserProperty(User user) {
        return userProperty.getAllByPk_User(user);
    }
}
