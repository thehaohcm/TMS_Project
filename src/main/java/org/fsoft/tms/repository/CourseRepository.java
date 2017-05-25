package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by thehaohcm on 5/19/17.
 */

public interface CourseRepository extends JpaRepository<Course, Integer>{
    public Set<Course> findAllById(Integer id);
}
