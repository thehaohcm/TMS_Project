package org.fsoft.tms.service;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 5/23/2017.
 */
@Service
public class ServiceCategory {
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
