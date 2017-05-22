package org.fsoft.tms.controller;

import org.aspectj.weaver.ast.Test;
import org.fsoft.tms.entity.*;
import org.fsoft.tms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/18/17.
 */

@RestController
@RequestMapping(value="/tms")
public class MainController {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TestTableRepository testTableRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @GetMapping(path="/role/add")
    public @ResponseBody Boolean addNewRole(@RequestParam String name){
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

    @RequestMapping("/permission/getall")
    public List<Permission> getAllPermissions(){
        return permissionRepository.findAll();
    }

//    @RequestMapping("/category/getall")
//    public List<Category> getAllCategories(){
//        return categoryRepository.findAll();
//    }

    @RequestMapping("/user/getall")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @RequestMapping("/category/getall")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @RequestMapping("/course/getall")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @RequestMapping("/topic/getall")
    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }

    @RequestMapping("/role/permission")
    public Set<Permission> setPermissions(){
        return roleRepository.findOne(1).getPermissions();

    }

    @RequestMapping("/property/getall")
    public List<Property> getAllPermission(){
        return propertyRepository.findAll();
    }

    @RequestMapping("/userproperty/getall")
    public Set<UserProperty> getAllUserProperty(){
        return userRepository.findOne(2).getUserProperties();
    }



    @RequestMapping(value="/hello")
    public String getString(){
        return "HelloWorld";
    }

    @RequestMapping("/testtable")
    public List<TestTable> getListTestTable(){
        return testTableRepository.findAll();
    }



//    @RequestMapping(name = "/abc")
//    public List<Course> abc(){
//
//        //return courseRepository.findCourseByCategoryID(1);
//    }
//    @GetMapping(path = "/category/add")
//    public @ResponseBody Boolean addCategory(@RequestParam String name,@RequestParam String description){
//        try {
//            Category c = new Category(name, description);
//            categoryRepository.save(c);
//        }catch(Exception ex){
//            return false;
//        }
//        return true;
//    }
//
//    @GetMapping(path="/category/getall")
//    public @ResponseBody Iterable<Category> getAllCategory(){
//        return categoryRepository.findAll();
//    }
//
//    @GetMapping(path="/category/findByID")
//    public @ResponseBody Category findCategoryByID(Integer id) {
//        Category c = categoryRepository.findOne(id);
//        return c;
//    }



}
