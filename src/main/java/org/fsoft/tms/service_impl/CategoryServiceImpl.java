package org.fsoft.tms.service_impl;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.repository.CategoryRepository;
import org.fsoft.tms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Isabella on 29-May-2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category cat) {
        categoryRepository.save(cat);
    }

    @Override
    public void deleteCategory(int id) {
        //categoryRepository.delete(id);
        Category temp = categoryRepository.findOne(id);
        temp.setActive(false);
        categoryRepository.save(temp);
    }

    @Override
    public void updateCategory(Category cat) {
        Category temp = categoryRepository.findOne(cat.getId());
        temp.setName(cat.getName());
        temp.setDescription(cat.getDescription());
        temp.setActive(true);
        categoryRepository.save(temp);
    }

    @Override
    public Category findOneCategory(int id) {
        return categoryRepository.findOne(id);
    }
}
