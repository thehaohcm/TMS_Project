package org.fsoft.tms.repository;

import org.fsoft.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by DELL on 5/25/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    public Set<User> findAllById(Integer id);
    public User findUserByUsername(String username);
}
