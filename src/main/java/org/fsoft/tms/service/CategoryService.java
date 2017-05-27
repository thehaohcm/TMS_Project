package org.fsoft.tms.service;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/23/2017.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category cat) {
        categoryRepository.save(cat);
    }

    public void deleteCategory(int id) {
        //categoryRepository.delete(id);
        Category temp = categoryRepository.findOne(id);
        temp.setActive(false);
        categoryRepository.save(temp);
    }

    public void updateCategory(Category cat) {
        Category temp = categoryRepository.findOne(cat.getId());
        temp.setName(cat.getName());
        temp.setDescription(cat.getDescription());
        categoryRepository.save(temp);
    }

    public Category findOneCategory(int id) {
        return categoryRepository.findOne(id);
    }

}
