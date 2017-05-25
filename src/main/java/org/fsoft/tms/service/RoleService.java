package org.fsoft.tms.service;

import org.fsoft.tms.entity.Role;
import org.fsoft.tms.repository.PermissionRepository;
import org.fsoft.tms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class RoleService {
    @Autowired
    RoleRepository service;

    @Autowired
    PermissionRepository permissionService;

    public List<Role> getAllRole() {
        return service.findAll();
    }

    public void addRole(Role role) {
        service.save(role);
    }

    public Role findOneCourse(int id) {
        return service.findOne(id);
    }

    public void updateRole(Role c) {
        Role temp = service.findOne(c.getId());
        temp.setName(c.getName());
        service.save(temp);
    }

    public void addPermissionForRole() {
        Role temp = service.findOne(1);
        temp.setPermissions(permissionService.findPermissionABCSById(1));
        service.save(temp);
    }
}
