package org.fsoft.tms.service;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.Course;
import org.fsoft.tms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class ServiceCourse {
    @Autowired
    private CourseRepository service;

    public List<Course> getAllCourse() {
        return service.findAll();
    }

    public void addCourse(Course course) {
        service.save(course);
    }

    public Course findOneCourse(int id) {
        return service.findOne(id);
    }

    public void updateCourse(Course c) {
        Course temp = service.findOne(c.getId());
        temp.setName(c.getName());
        temp.setDescription(c.getDescription());
        temp.setCategory_course(c.getCategory_course());
        temp.setCreatedDate(c.getCreatedDate());
        service.save(temp);
    }

}
