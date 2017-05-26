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
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionService;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }

    public Role findOneCourse(int id) {
        return roleRepository.findOne(id);
    }

    public void updateRole(Role c) {
        Role temp = roleRepository.findOne(c.getId());
        temp.setName(c.getName());
        roleRepository.save(temp);
    }

    public void addPermissionForRole() {
        Role temp = roleRepository.findOne(1);
        temp.setPermissions(permissionService.findPermissionABCSById(1));
        roleRepository.save(temp);
    }
}
