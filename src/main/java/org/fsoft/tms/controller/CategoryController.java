package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/category/getall")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
