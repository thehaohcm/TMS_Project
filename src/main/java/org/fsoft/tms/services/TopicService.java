package org.fsoft.tms.services;

import org.fsoft.tms.entity.Topic;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface TopicService {

    List<Topic> getAllTopic();

    Topic finOneById(Integer id);
}
