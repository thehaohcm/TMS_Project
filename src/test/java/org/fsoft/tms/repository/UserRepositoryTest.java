package org.fsoft.tms.repository;

import org.fsoft.tms.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Isabella on 28-May-2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest//(classes = {RepositoryConfiguration.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSaveCategory(){

//        User user = new User("Thanh","Thanh");
//        user.setRole(roleRepository.findOne(4));
//        user.setManager(userRepository.findUserByUsername("nv001"));
//        assertNull(user.getId());
//        userRepository.save(user);
//        assertNotNull(user.getId());
//
//        User fetchedUser = userRepository.findOne(user.getId());
//        assertNotNull(fetchedUser);
//        assertEquals(user.getId(), fetchedUser.getId());
//        assertEquals(user.getUsername(), fetchedUser.getUsername());
//        assertEquals(user.getPassword(), fetchedUser.getPassword());
//
//        fetchedUser.setPassword("Thanh1");
//        userRepository.save(fetchedUser);
//        User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getId());
//        assertEquals(fetchedUser.getPassword(), fetchedUpdatedUser.getPassword());
//
//        long userCount = userRepository.count();
//        assertEquals(userCount, 6);
//
//        Iterable<User> categories = userRepository.findAll();
//        int count = 0;
//        for(User c : categories){
//            count++;
//        }
//        assertEquals(count, 6);
//
//        userRepository.delete(fetchedUpdatedUser);
//        User fetchedDeletedUser = userRepository.findOne(fetchedUser.getId());
//        assertNull(fetchedDeletedUser);

    }

    @Test
    public void findAllById() throws Exception {
    }

    @Test
    public void findUserByUsername() throws Exception {
    }

    @Test
    public void findAllByRole() throws Exception {
    }

}