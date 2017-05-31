package org.fsoft.tms.service;

import org.fsoft.tms.entity.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Isabella on 29-May-2017.
 */
public interface UserService {

    List<User> getAllUser();

    List<User> getAllUserByRole(int roleID);

    void addUser(User u, int roleId);

    User findOneUser(int id);

    void updateUser(User c);

    void addTrainee(User u, int staffId);

    void addPropertyForUser();

    void addRole();

    void addManager();

    void addCourse();

    void addTopic();

    void saveUser(User user);

    void saveTrainer(TrainerInfo trainerInfo);

    Set<UserProperty> setTrainerProperty(User user, String name, String email, String phone, String address);
}
