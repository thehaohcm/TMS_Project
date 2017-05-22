package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Property;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.entity.UserProperty;
import org.fsoft.tms.entity.UserPropertyKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
public interface UserPropertyRepository extends JpaRepository<UserProperty,UserPropertyKey> {
    public List<UserProperty> findAllByUser(User user);
}
