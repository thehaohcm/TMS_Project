package org.fsoft.tms.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fsoft.tms.entity.Category;
import org.fsoft.tms.repository.CategoryRepository;
import org.fsoft.tms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thehaohcm on 5/30/17.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger logger = LogManager.getLogger();
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
        logger.debug("vao roi tui bay oi "+id );
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
