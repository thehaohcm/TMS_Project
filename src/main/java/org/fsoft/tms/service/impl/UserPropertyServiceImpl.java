package org.fsoft.tms.service.impl;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.repository.UserPropertyRepository;
import org.fsoft.tms.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thehaohcm on 5/30/17.
 */
@Service
public class UserPropertyServiceImpl implements UserPropertyService {

    @Autowired
    private UserPropertyRepository userProperty;

    @Override
    public List<UserProperty> getListUserProperty(User user) {
        return userProperty.getAllByPk_User(user);
    }
}
