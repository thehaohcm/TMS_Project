package org.fsoft.tms.service;

import org.fsoft.tms.entity.Role;
import org.fsoft.tms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/23/2017.
 */
@Service
public class ServiceRole {
    @Autowired
    private RoleRepository service;

    public List<Role> listRole() {
        return service.findAll();
    }
}
