package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/23/2017.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository service;

    public List<Category> getListCategory() {
        return service.findAll();
    }

    public void addCategory(Category cat) {
        service.save(cat);
    }

    public void deleteCategory(int id) {
        service.delete(id);
    }

    public void updateCategory(Category cat) {
        Category temp = service.findOne(cat.getId());
        temp.setName(cat.getName());
        temp.setDescription(cat.getDescription());
        service.save(temp);
    }

    public Category findOneCategory(int id) {
        return service.findOne(id);
    }

}
