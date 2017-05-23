package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Permission;
import org.fsoft.tms.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/permission")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @RequestMapping("/getall")
    public List<Permission> getAllPermissions(){
        return permissionRepository.findAll();
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addPermission(@RequestBody Permission permission){
        if(permission==null)
            return false;
        try {
            permissionRepository.save(permission);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public boolean editPermission(@RequestBody Permission permission){
        if(permission==null)
            return false;
        try {
            permissionRepository.save(permission);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removePermission(@RequestBody Permission permission){
        if(permission==null)
            return false;
        try {
            permissionRepository.save(permission);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
