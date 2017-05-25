package com.example.demo.repository;

import com.example.demo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by DELL on 5/24/2017.
 */
public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    public Set<Permission> findPermissionABCSById(Integer id);
}
