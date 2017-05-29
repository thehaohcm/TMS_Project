package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Topic;
import org.fsoft.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by DELL on 5/25/2017.
 */
public interface TopicRepository extends JpaRepository<Topic, Integer>{
    public List<Topic> findAllByTrainer(User user);
}
