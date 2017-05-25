package com.example.demo.repository;

import com.example.demo.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 5/25/2017.
 */
public interface TopicRepository extends JpaRepository<Topic, Integer>{
}
