package org.fsoft.tms.service;

import org.fsoft.tms.entity.Permission;
import org.fsoft.tms.repository.PermissionRepository;
import org.fsoft.tms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<Permission> getAllPermission() {
        return permissionRepository.findAll();
    }

    public void addPermission(Permission role) {
        permissionRepository.save(role);
    }

    public Permission findOnePermisison(int id) {
        return permissionRepository.findOne(id);
    }

    public void updatePermission(Permission c) {
        Permission temp = permissionRepository.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        permissionRepository.save(temp);
    }

    public void addRole() {
        Permission temp = permissionRepository.findOne(1);
        temp.setRoles(roleRepository.findAllById(1));
        permissionRepository.save(temp);
    }
}
