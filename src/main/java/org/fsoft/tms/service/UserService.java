package org.fsoft.tms.service;

import org.fsoft.tms.entity.*;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface UserService {

    List<User> getAllUser();

    List<User> getAllUserByRole(int roleID);

    void addUser(User u);

    User findOneUser(int id);

    void updateUser(User c);

    void addPropertyForUser();

    void addRole();

    void addManager();

    void addCourse();

    void addTopic();
}
