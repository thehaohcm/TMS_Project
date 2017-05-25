package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Created by DELL on 5/24/2017.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
    public Set<Role> findAllById(Integer id);
}
