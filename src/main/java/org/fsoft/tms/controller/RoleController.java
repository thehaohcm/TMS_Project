package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Permission;
import org.fsoft.tms.entity.Role;
import org.fsoft.tms.repository.PermissionRepository;
import org.fsoft.tms.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

//    @GetMapping(path="/add")
//    public @ResponseBody
//    Boolean addNewRole(@RequestParam String name){
//        try {
//            Role r = new Role();
//            r.setName(name);
//            roleRepository.save(r);
//        }catch(Exception ex){
//            return false;
//        }
//        return true;
//    }

    @RequestMapping("/getall")
    public List<Role> getAllRole(){

        return roleRepository.findAll();
    }



    @RequestMapping("/findByID")
    public Role findRoleByID(Integer id){
        Role r=roleRepository.findOne(id);
        return r;
    }

    @RequestMapping("/permission")
    public Set<Permission> setPermissions(){
        return roleRepository.findOne(1).getPermissions();
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addRole(@RequestBody Role role){
        if(role==null)
            return false;
        try {
            roleRepository.save(role);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public boolean editRole(@RequestBody Role role){
        if(role==null)
            return false;
        try {
            roleRepository.save(role);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeRole(@RequestBody Role role){
        if(role==null)
            return false;
        try {
            roleRepository.save(role);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
