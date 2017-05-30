package org.fsoft.tms.service.impl;

import org.fsoft.tms.entity.Course;
import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.TopicRepository;
import org.fsoft.tms.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    TopicRepository topic;

    @Override
    public List<Topic> getAllTopic() {
        return topic.findAll();
    }

    @Override
    public Topic finOneById(Integer id) {
        return topic.findOne(id);
    }

    @Override
    public List<Topic> findAllTopicByTrainer(User user) {
        return topic.findAllByTrainer(user);
    }

    @Override
    public List<Topic> findAllTopicByCourse(User user, Course course) {
        List<Topic> arrTopic = topic.findAllByTrainer(user);
        List<Topic> arrTopics = new ArrayList<>();
        for (Topic tp: arrTopic) {
            if (tp.getCourse().equals(course)) {
                arrTopics.add(tp);
            }
        }
        return arrTopics;
    }

    @Override
    public List<Course> findAllCourseOfUser(User user) {
        List<Topic> arrTopic = topic.findAllByTrainer(user);
        List<Course> arrCourses = new ArrayList<>();
        int j = 0;
        if (arrTopic.size() > 0) {
            arrCourses.add(arrTopic.get(0).getCourse());
            for (int i = 1; i < arrTopic.size(); i++) {
                j = 0;
                for (Course c:arrCourses) {
                    if(arrTopic.get(i).getCourse().equals(c))
                        j++;
                }
                if(j == 0)
                    arrCourses.add(arrTopic.get(i).getCourse());
            }
        }
        return arrCourses;
    }

    @Override
    public void updateTopic(Topic t) {
        Topic temp = topic.findOne(t.getId());
        temp.setTitle(t.getTitle());
        temp.setContent(t.getContent());
        topic.save(temp);
    }

    @Override
    public void deleteTopic(int id) {
        Topic temp = topic.findOne(id);
        temp.setActive(false);
        topic.save(temp);
    }

    @Override
    public void addTopic(Topic t) {
        t.setActive(true);
        topic.save(t);
    }
}
