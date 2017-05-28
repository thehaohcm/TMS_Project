package org.fsoft.tms.repository;

import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.entity.UserPropertyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by DELL on 5/27/2017.
 */
public interface UserPropertyRepository extends JpaRepository<UserProperty, UserPropertyId>{
//    public List<UserProperty> findAllByUser(User user);
    public List<UserProperty> getAllByPk_User(User user);
}
