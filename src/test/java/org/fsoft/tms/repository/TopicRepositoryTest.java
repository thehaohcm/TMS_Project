package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Isabella on 1-Jun-2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest//(classes = {RepositoryConfiguration.class})
public class TopicRepositoryTest {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void testSaveTopic(){

        Topic topic = new Topic();
        topic.setTitle("The new Invoice");
        topic.setContent("The addition of the 1000 miles highway");
        topic.setActive(true);
        topic.setCourse(courseRepository.findOne(1));
        assertNull(topic.getId());
        topicRepository.save(topic);
        assertNotNull(topic.getId());

        Topic fetchedTopic = topicRepository.findOne(topic.getId());
        assertNotNull(fetchedTopic);
        assertEquals(topic.getId(), fetchedTopic.getId());
        assertEquals(topic.getContent(), fetchedTopic.getContent());

        fetchedTopic.setContent("ABC");
        topicRepository.save(fetchedTopic);
        Topic fetchedUpdatedTopic = topicRepository.findOne(fetchedTopic.getId());
        assertEquals(fetchedTopic.getContent(), fetchedUpdatedTopic.getContent());

        long topicCount = topicRepository.count();
        assertEquals(topicCount, 4);

        Iterable<Topic> topics = topicRepository.findAll();
        int count = 0;
        for(Topic c : topics){
            count++;
        }
        assertEquals(count, 4);

        fetchedUpdatedTopic.setActive(false);
        topicRepository.save(fetchedUpdatedTopic);
        Topic fetchedDeletedTopic = topicRepository.findOne(fetchedUpdatedTopic.getId());
        assertEquals(fetchedDeletedTopic.getActive(), false);

    }

//    @Test
//    public void findAllByTrainer() throws Exception {
//    }
//
//    @Test
//    public void findAllByCourse_Staff() throws Exception {
//    }

}