package org.fsoft.tms.service_impl;

import org.fsoft.tms.entity.*;
import org.fsoft.tms.repository.*;
import org.fsoft.tms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserPropertyRepository userPropertyRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByRole(int roleID) {
        Role role = roleRepository.findOne(roleID);
        return userRepository.findAllByRole(role);
    }

    @Override
    public void addUser(User u) {
        userRepository.save(u);
    }

    @Override
    public User findOneUser(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public void updateUser(User c) {
        User temp = userRepository.findOne(c.getId());
        temp.setUsername(c.getUsername());
        temp.setPassword(c.getPassword());
        userRepository.save(temp);
    }

    @Override
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
        userRepository.save(temp);

    }

    @Override
    public void addRole() {
        User temp = new User();
        temp.setActive(true);
        temp.setPassword("a2");
        temp.setUsername("a2");

        Role role = roleRepository.findOne(2);
        temp.setRole(role);
        userRepository.save(temp);
    }

    @Override
    public void addManager() {
        User temp1 = new User();
        temp1.setActive(true);
        temp1.setPassword("a2");
        temp1.setUsername("a2");

        Role role1 = roleRepository.findOne(2);
        temp1.setRole(role1);
        temp1.setManager(null);
        userRepository.save(temp1);

        User temp = new User();
        temp.setActive(false);
        temp.setPassword("a23");
        temp.setUsername("a23");

        Role role = roleRepository.findOne(2);
        temp.setRole(role);

        temp.setManager(userRepository.findOne(1));
        userRepository.save(temp);
    }

    @Override
    public void addCourse() {
        User temp1 = userRepository.findOne(2);
        temp1.setTraineeCourses(courseRepository.findAllById(3));
        userRepository.save(temp1);
    }

    @Override
    public void addTopic() {
        User temp1 = userRepository.findOne(7);
        Course tempCourse = courseRepository.findOne(2);
        Topic topic = new Topic();
        topic.setTrainer(temp1);
        topic.setCourse(tempCourse);
        topic.setTitle("logic");
        topic.setContent("tri tue");
        topicRepository.save(topic);
    }
}
