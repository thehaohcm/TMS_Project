package org.fsoft.tms.service;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public Course findOneCourse(int id) {
        return courseRepository.findOne(id);
    }

    public void updateCourse(Course c) {
        Course temp = courseRepository.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        temp.setCategory(c.getCategory());
        courseRepository.save(temp);
    }

    public void addTrainingStaff() {
        Course temp = courseRepository.findOne(2);
        temp.setStaff(userRepository.findOne(1));
        courseRepository.save(temp);
    }

    public void addTrainees() {
        Course temp = courseRepository.findOne(2);
        temp.setTrainees(userRepository.findAllById(3));
        courseRepository.save(temp);
    }
}
