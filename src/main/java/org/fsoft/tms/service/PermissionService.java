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
    PermissionRepository service;

    @Autowired
    RoleRepository roleRepository;

    public List<Permission> getAllPermission() {
        return service.findAll();
    }

    public void addPermission(Permission role) {
        service.save(role);
    }

    public Permission findOnePermisison(int id) {
        return service.findOne(id);
    }

    public void updatePermission(Permission c) {
        Permission temp = service.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        service.save(temp);
    }

    public  void addRole() {
        Permission temp = service.findOne(1);
        temp.setRoles(roleRepository.findAllById(1));
        service.save(temp);
    }
}
