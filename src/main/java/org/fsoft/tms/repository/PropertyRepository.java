package com.example.demo.repository;

import com.example.demo.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 5/25/2017.
 */
public interface PropertyRepository extends JpaRepository<Property, Integer> {
}
