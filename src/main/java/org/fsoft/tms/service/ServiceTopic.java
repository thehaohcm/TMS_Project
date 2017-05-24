package org.fsoft.tms.service;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.CategoryRepository;
import org.fsoft.tms.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/24/2017.
 */
@Service
public class ServiceTopic {
    @Autowired
    private TopicRepository service;

    public List<Topic> getListTopic() {
        return service.findAll();
    }

    public void addTopic(Topic topic) {
        service.save(topic);
    }

    public void deleteTopic(int id) {
        service.delete(id);
    }

    public void updateTopic(Topic topic) {
        Topic temp = service.findOne(topic.getId());
        temp.setContent(topic.getContent());
        temp.setTitle(topic.getTitle());
        service.save(temp);
    }

    public Topic findOneTopic(int id) {
        return service.findOne(id);
    }

}
