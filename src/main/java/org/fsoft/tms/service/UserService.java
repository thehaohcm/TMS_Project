package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class UserService {
    @Autowired
    UserRepository service;

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TopicRepository topicRepository;

    public List<User> getAllUser() {
        return service.findAll();
    }

    public void addUser(User u) {
        service.save(u);
    }

    public User findOneUser(int id) {
        return service.findOne(id);
    }

    public void updateUser(User c) {
        User temp = service.findOne(c.getId());
        temp.setUsername(c.getUsername());
        temp.setPassword(c.getPassword());
        service.save(temp);
    }

    public void addPropertyForUser() {
        User temp = new User();
        temp.setActive(true);
        temp.setPassword("a1");
        temp.setUsername("a1");

        Property property = new Property();
        property.setDescription("adf1");
        property.setName("ad1s");
        propertyRepository.save(property);

        UserProperty userProperty = new UserProperty();
        userProperty.setUser(temp);
        userProperty.setProperty(property);
        userProperty.setValue("Tran Manh Cam");

        temp.getUserProperties().add(userProperty);
        service.save(temp);

    }

    public void addRole() {
        User temp = new User();
        temp.setActive(true);
        temp.setPassword("a2");
        temp.setUsername("a2");

        Role role = roleRepository.findOne(2);
        temp.setRole(role);
        service.save(temp);
    }

    public void addManager() {
        User temp1 = new User();
        temp1.setActive(true);
        temp1.setPassword("a2");
        temp1.setUsername("a2");

        Role role1 = roleRepository.findOne(2);
        temp1.setRole(role1);
        temp1.setManager(null);
        service.save(temp1);

        User temp = new User();
        temp.setActive(false);
        temp.setPassword("a23");
        temp.setUsername("a23");

        Role role = roleRepository.findOne(2);
        temp.setRole(role);

        temp.setManager(service.findOne(1));
        service.save(temp);
    }

    public void addCourse() {
        User temp1 = service.findOne(2);
        temp1.setTraineeCourses(courseRepository.findAllById(3));
        service.save(temp1);
    }

    public void addTopic() {
        User temp1 = service.findOne(7);
        Course tempCourse = courseRepository.findOne(2);
        Topic topic = new Topic();
        topic.setTrainer(temp1);
        topic.setCourse(tempCourse);
        topic.setTitle("logic");
        topic.setContent("tri tue");
        topicRepository.save(topic);
    }
}
