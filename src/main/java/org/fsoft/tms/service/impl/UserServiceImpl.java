package org.fsoft.tms.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.*;
import org.fsoft.tms.repository.*;
import org.fsoft.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by thehaohcm on 5/30/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LogManager.getLogger();

    @Autowired
    PasswordEncoder passwordEncoder;

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
    public void addUser(User u, int roleId) {
        Role role = roleRepository.findOne(roleId);
        u.setRole(role);
        u.setActive(true);
        User manager = userRepository.findOne(1);
        u.setManager(manager);
        String password = u.getPassword();
        u.setPassword(encode(password));
        userRepository.save(u);
    }

    @Override
    public void addTrainee(User u, int staffId) {
        Role role = roleRepository.findOne(4);
        u.setRole(role);
        u.setActive(true);
        User manager = userRepository.findOne(staffId);
        u.setManager(manager);
        String password = u.getPassword();
        u.setPassword(encode(password));
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
        String password = c.getPassword();
        temp.setPassword(encode(password));
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

    @Override
    public void saveUser(User user) {
        User user1 = userRepository.findOne(user.getId());
        user1.setUserProperties(user.getUserProperties());
        userRepository.save(user1);
    }

    @Override
    public void saveTrainer(TrainerInfo trainerInfo) {
        Set<UserProperty> userProperties = new HashSet<>(0);

        logger.debug("-1:"+trainerInfo.getName());

        userProperties = setTrainerProperty(trainerInfo.getUser(), trainerInfo.getName(),
                trainerInfo.getEmail(), trainerInfo.getPhone(), trainerInfo.getAddress());
        for(UserProperty userProperty : userProperties)
            logger.debug("0:"+userProperty.getValue());

        User user = userRepository.findOne(trainerInfo.getUser().getId());
        user.setUserProperties(userProperties);
        logger.debug("1:"+user.getUsername());
        logger.debug("2:"+user.getPassword());
        Set<UserProperty> userProperties1 = user.getUserProperties();
        for(UserProperty userProperty : userProperties1)
            logger.debug("3:"+userProperty.getValue());
//        logger.debug("4:"+user.getManager().toString());
        saveUser(user);
    }

    @Override
    public Set<UserProperty> setTrainerProperty(User user, String name, String email, String phone, String address) {
        UserProperty userProperty = new UserProperty();
        Set<UserProperty> userProperties = new HashSet<>(0);
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(1));
        userProperty.setValue(name);
        userProperties.add(userProperty);
        userProperty = new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(10));
        userProperty.setValue(email);
        userProperties.add(userProperty);
        userProperty = new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(9));
        userProperty.setValue(phone);
        userProperties.add(userProperty);
        userProperty = new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(8));
        userProperty.setValue(address);
        userProperties.add(userProperty);
        return userProperties;
    }

    public void saveTrainee(TraineeInfo trainee){
        Set<UserProperty> userProperties=new HashSet<>(0);
        userProperties=setTraineeProperty(trainee.getUser(),trainee.getName(),trainee.getBirthDate(),
                trainee.getEducation(),trainee.getProgrammingLanguage(),trainee.getToeicScore(),
                trainee.getExperienceDetail(),trainee.getDepartment(),trainee.getLocation());

        User user=userRepository.findOne(trainee.getUser().getId());
        user.setUserProperties(userProperties);
        saveUser(user);
    }

    public Set<UserProperty> setTraineeProperty(User user,String name,String birthDate,String education,
                                                String programmingLanguage,String toeicScrore,String experienceDetail,
                                                String department,String localtion){
        Set<UserProperty> userProperties=new HashSet<>(0);
        UserProperty userProperty;

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(1));
        userProperty.setValue(name);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(2));
        userProperty.setValue(birthDate);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(3));
        userProperty.setValue(education);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(4));
        userProperty.setValue(programmingLanguage);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(5));
        userProperty.setValue(toeicScrore);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(6));
        userProperty.setValue(experienceDetail);
        userProperties.add(userProperty);

        userProperty=new UserProperty();
        userProperty.setUser(user);
        userProperty.setProperty(propertyRepository.findOne(7));
        userProperty.setValue(department);
        userProperties.add(userProperty);

        return userProperties;
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository.findOne(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
