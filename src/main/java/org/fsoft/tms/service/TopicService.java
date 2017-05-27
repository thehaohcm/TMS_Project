package org.fsoft.tms.service;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/27/2017.
 */
@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Topic finOneById(Integer id) {
        return topicRepository.findOne(id);
    }
}
