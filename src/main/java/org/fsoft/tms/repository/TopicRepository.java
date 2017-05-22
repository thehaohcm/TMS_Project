package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thehaohcm on 5/21/17.
 */
public interface TopicRepository extends JpaRepository<Topic,Integer> {
}
