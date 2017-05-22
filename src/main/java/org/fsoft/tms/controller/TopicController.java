package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */

@RestController
@RequestMapping(value="/tms")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping("/topic/getall")
    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }
}
