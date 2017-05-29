package org.fsoft.tms.service;

import org.fsoft.tms.entity.Course;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface CourseService {

    List<Course> getAllCourse();

    void addCourse(Course course);

    Course findOneCourse(int id);

    void updateCourse(Course c);

    void addTrainingStaff();

    void addTrainees();
}
