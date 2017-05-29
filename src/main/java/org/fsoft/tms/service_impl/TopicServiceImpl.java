package org.fsoft.tms.service_impl;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.TopicRepository;
import org.fsoft.tms.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public Topic finOneById(Integer id) {
        return topicRepository.findOne(id);
    }
}
