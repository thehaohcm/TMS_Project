package org.fsoft.tms.service;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.entity.User;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface TopicService {

    List<Topic> getAllTopic();

    Topic finOneById(Integer id);

    List<Topic> findAllTopicByTrainer(User user);

    List<Topic> findAllTopicByCourse(User user, Course course);

    List<Course> findAllCourseOfUser(User user);

    void updateTopic(Topic topic);

    void deleteTopic(int id);

    void addTopic(Topic t);
}