package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by thehaohcm on 5/19/17.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public List<Category> findAllByNameContains(String name);
    public List<Category> findAllByNameIsLike(String name);
}
