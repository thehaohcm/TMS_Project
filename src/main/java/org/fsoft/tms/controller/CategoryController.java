package org.fsoft.tms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RequestMapping(value = "/staff/category")
public class CategoryController {

    private final Logger logger = LogManager.getLogger();
    @Autowired
    private CategoryService category;

    @RequestMapping(value = "/")
    public String getAllCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("listCategory", category.getListCategory());
        return "category/index";
    }

    @RequestMapping(value = "/add")
    public String getPageAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @RequestMapping(value = "/addCategory")
    public String addCategory(@ModelAttribute Category cat) {
        category.addCategory(cat);
        return "redirect:/staff/category/";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCatogory(@PathVariable String id) {
        logger.debug("vao rui");
        category.deleteCategory(Integer.parseInt(id));
        return "redirect:/staff/category/";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateCategory(@PathVariable String id, Model model) {
        Category cat = category.findOneCategory(Integer.parseInt(id));
        model.addAttribute("category", cat);
        return "category/update";
    }

    @RequestMapping(value = "/update")
    public String updateCatogory(@ModelAttribute Category cat) {
        category.updateCategory(cat);
        return "redirect:/staff/category/";
    }

}
