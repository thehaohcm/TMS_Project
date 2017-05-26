package org.fsoft.tms.controller;

import org.fsoft.tms.entity.Category;
import org.fsoft.tms.service.CategoryService;
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
@RequestMapping(value = "/demo/server/category")
public class CategoryController {
    @Autowired
    private CategoryService category;

    @RequestMapping(value = "/getall")
    public String getAllCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("listCategory", category.getListCategory());
        return "category";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @RequestMapping(value = "/addCategory")
    public String addCategory(@ModelAttribute Category cat) {
        category.addCategory(cat);
        return "redirect:/demo/server/category/getall";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCatogory(@PathVariable String id) {
        category.deleteCategory(Integer.parseInt(id));
        return "redirect:/demo/server/category/getall";
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
        return "redirect:/demo/server/category/getall";
    }

    @RequestMapping(value = "/login")
    public String login() {
        //category.updateCategory(cat);
        return "login";
    }
}
