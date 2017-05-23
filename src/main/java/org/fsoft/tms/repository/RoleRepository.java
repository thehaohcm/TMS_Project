package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thehaohcm on 5/18/17.
 */
@Transactional
public interface RoleRepository extends JpaRepository<Role,Integer> {
    //List<Role> findRoleByName(String name);
}
