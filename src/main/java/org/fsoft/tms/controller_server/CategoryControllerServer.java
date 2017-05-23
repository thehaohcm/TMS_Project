package org.fsoft.tms.controller_server;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.entity.User;
import org.fsoft.tms.service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 5/23/2017.
 */
@Controller
@RequestMapping(value = "/tms/server/category")
public class CategoryControllerServer {
    @Autowired
    private ServiceCategory category;

    @RequestMapping(value = "/getall")
    public String getAllCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("listCategory", category.getListCategory());
        return "category";
    }

    @RequestMapping(value = "/add")
    public String addCategory(@ModelAttribute Category cat) {
        category.addCategory(cat);
        return "redirect:/tms/server/category/getall";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCatogory(@PathVariable String id) {
        category.deleteCategory(Integer.parseInt(id));
        return "redirect:/tms/server/category/getall";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCategory(@PathVariable String id, Model model) {
        Category cat = category.findOneCategory(Integer.parseInt(id));
        model.addAttribute("category", cat);
        model.addAttribute("listCategory", category.getListCategory());
        return "update_category";
    }

    @RequestMapping(value = "/update")
    public String updateCatogory(@ModelAttribute Category cat) {
        category.updateCategory(cat);
        return "redirect:/tms/server/category/getall";
    }
}
