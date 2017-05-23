package org.fsoft.tms.service;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/23/2017.
 */
@Service
public class ServiceUser {
    @Autowired
    private UserRepository service;

    public List<User> getListUser() {
        return service.findAll();
    }
}
