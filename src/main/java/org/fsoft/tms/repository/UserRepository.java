package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thehaohcm on 5/19/17.
 */
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    //public List<User> findAll();

    public List<User> findUserByUser
}
