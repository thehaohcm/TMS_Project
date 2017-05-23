package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */

@RestController
@RequestMapping(value="/tms/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @RequestMapping("/getall")
    public List<Topic> getAllTopic(){
        return topicRepository.findAll();
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public boolean addTopic(@RequestBody Topic topic){
        if(topic==null)
            return false;
        try {
            topicRepository.save(topic);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method = RequestMethod.POST)
    public boolean editTopic(@RequestBody Topic topic){
        if(topic==null)
            return false;
        try {
            topicRepository.save(topic);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/remove",method = RequestMethod.POST)
    public boolean removeTopic(@RequestBody Topic topic){
        if(topic==null)
            return false;
        try {
            topicRepository.save(topic);
        }catch(Exception ex){
            return false;
        }
        return true;
    }
}
