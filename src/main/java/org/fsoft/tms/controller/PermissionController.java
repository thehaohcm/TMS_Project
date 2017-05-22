package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Permission;
import org.fsoft.tms.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class PermissionController {

    @Autowired
    private PermissionRepository permissionRepository;

    @RequestMapping("/permission/getall")
    public List<Permission> getAllPermissions(){
        return permissionRepository.findAll();
    }
}
