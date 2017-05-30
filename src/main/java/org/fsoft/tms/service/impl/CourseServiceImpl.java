package org.fsoft.tms.service.impl;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.UserRepository;
import org.fsoft.tms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thehaohcm on 5/30/17.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course findOneCourse(int id) {
        return courseRepository.findOne(id);
    }

    @Override
    public void updateCourse(Course c) {
        Course temp = courseRepository.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        temp.setCategory(c.getCategory());
        courseRepository.save(temp);
    }

    @Override
    public void addTrainingStaff() {
        Course temp = courseRepository.findOne(2);
        temp.setStaff(userRepository.findOne(1));
        courseRepository.save(temp);
    }

    @Override
    public void addTrainees() {
        Course temp = courseRepository.findOne(2);
        temp.setTrainees(userRepository.findAllById(3));
        courseRepository.save(temp);
    }
}
