package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Permission;
import org.fsoft.tms.entity.Role;
import org.fsoft.tms.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(path="/role/add")
    public @ResponseBody
    Boolean addNewRole(@RequestParam String name){
        try {
            Role r = new Role();
            r.setName(name);
            roleRepository.save(r);
        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @RequestMapping("/role/getall")
    public @ResponseBody Iterable<Role> getAllRole(){
        return roleRepository.findAll();
    }

    @RequestMapping("/role/findByID")
    public Role findRoleByID(Integer id){
        Role r=roleRepository.findOne(id);
        return r;
    }

    @RequestMapping("/role/permission")
    public Set<Permission> setPermissions(){
        return roleRepository.findOne(1).getPermissions();

    }
}
