package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thehaohcm on 5/22/17.
 */
@RestController
@RequestMapping(value="/tms/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/getall")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public boolean createCategory(@RequestBody Category category){
        if(category==null)
            return false;
        try {
            categoryRepository.save(category);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @RequestMapping(value="/edit",method=RequestMethod.POST)
    public boolean editCategory(@RequestBody Category category){
        if(category==null)
            return false;
        try {
            categoryRepository.save(category);
        }catch(Exception ex){
            return false;
        }
        return true;

    }

    @RequestMapping(value = "/remove",method=RequestMethod.POST)
    public boolean removeCategory(@RequestBody Category category){
        if(category==null)
            return false;
        try {
            categoryRepository.delete(category);
        }catch(Exception ex){
            return false;
        }
        return true;
    }

}
