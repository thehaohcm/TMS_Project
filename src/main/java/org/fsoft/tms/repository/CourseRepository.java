package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thehaohcm on 5/19/17.
 */
//public class CourseRepository{
public interface CourseRepository extends JpaRepository<Course, Integer>{
    //List<Course> findCourseByCategoryID(Integer categoryID);
    //public List<Course> findAll();
}
