package com.thanhtrt.BlogApp.controller;

import com.thanhtrt.BlogApp.model.Blog;
import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
   @Autowired
    CategoryService categoryService;
   @GetMapping("/create-category")
   public ModelAndView showNewCategoryForm() {
       ModelAndView modelAndView = new ModelAndView("/category/create");
       modelAndView.addObject("category", new Blog());
       return modelAndView;
   }
    @PostMapping("/create-category")
    public ModelAndView saveBlog(@ModelAttribute("category")Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView(("/category/create"));
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New Category created successfully");
        return modelAndView;
    }
}
