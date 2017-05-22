package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thehaohcm on 5/19/17.
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    public List<Permission> findAll();
}
