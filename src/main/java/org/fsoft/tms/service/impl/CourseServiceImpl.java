
package org.fsoft.tms.service.impl;
import org.fsoft.tms.CurrentUser;
import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.CourseRepository;
import org.fsoft.tms.repository.UserRepository;
import org.fsoft.tms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCourseByStaff() {
        User user = CurrentUser.getInstance().getUser();
        return courseRepository.findAllByStaff(user);
    }

    @Override
    public void addCourse(Course course) {
        course.setActive(true);
        course.setStaff(CurrentUser.getInstance().getUser());
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

    @Override
    public void deleteCourse(int id) {
        Course c = courseRepository.findOne(id);
        c.setActive(false);
        courseRepository.save(c);
    }

    @Override
    public List<Course> getAllCourseByCategory(Category c) {
        return  courseRepository.findAllByCategory(c);
    }
}
