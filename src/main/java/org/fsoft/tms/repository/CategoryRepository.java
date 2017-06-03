package org.fsoft.tms.repository;

import org.fsoft.tms.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by thehaohcm on 5/19/17.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public List<Category> findAllByActive(Boolean b);

    @Query("Select c from Category c where c.name LIKE concat('%',:input,'%') or  c.description LIKE concat('%',:input,'%')")
    List<Category> findAllByName(@Param("input") String input);
}

