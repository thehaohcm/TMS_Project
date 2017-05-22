package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by thehaohcm on 5/18/17.
 */
@Transactional
public interface RoleRepository extends CrudRepository<Role,Integer> {
    //List<Role> findRoleByName(String name);
}
