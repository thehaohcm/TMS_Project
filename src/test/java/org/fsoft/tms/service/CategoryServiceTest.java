package org.fsoft.tms.service;

import org.fsoft.tms.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Isabella on 28-May-2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void getListCategory() throws Exception {
        assertEquals(categoryRepository.findAll(), categoryService.getListCategory());
    }

    @Test
    public void addCategory() throws Exception {
    }

    @Test
    public void deleteCategory() throws Exception {
    }

    @Test
    public void updateCategory() throws Exception {
    }

    @Test
    public void findOneCategory() throws Exception {
    }

}