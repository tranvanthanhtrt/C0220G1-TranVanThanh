package com.thanhtrt.BlogApp.controller;


import com.thanhtrt.BlogApp.model.Blog;
import com.thanhtrt.BlogApp.model.Category;
import com.thanhtrt.BlogApp.service.BlogService;
import com.thanhtrt.BlogApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/new-blog")
    public ModelAndView showNewBlogForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/new");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/new-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView(("/blog/new"));
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView listBlog(@RequestParam(value = "category",defaultValue = "0") Optional<String> category, @PageableDefault(size = 4, sort = "writeOfDay") Pageable pageable, Model model) {
        Page<Blog> blogs;
        if(category.isPresent()){
            if(category.get().equals("0")){
                blogs=blogService.findAll(pageable);

            }else {
                model.addAttribute("category", category.get());
                Optional<Category> category1 = categoryService.findById(Long.parseLong(category.get()));
                blogs = blogService.findAllByCategory(category1, pageable);
            }
        }
        else {
            blogs=blogService.findAll(pageable);
            category= Optional.of("All");
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("category",category.get());
        modelAndView.addObject("total",blogs.getTotalElements());
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog.isPresent()) {
            modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView(("/blog/edit"));
        modelAndView.addObject("message", "Blog has modified successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog);

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message", "Blog has removed successfully");
        return "redirect:blogs";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog);

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/viewbycategory")
    public ModelAndView viewByCategory(@RequestParam String category, @PageableDefault(size = 4) Pageable pageable) {
        Page<Blog> blogs;
        if (category.equals("All")) {
            blogs = blogService.findAll(pageable);
        } else {

            Optional<Category> category1 = categoryService.findById(Long.parseLong(category));
            blogs = blogService.findAllByCategory(category1, pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs",blogs);
        modelAndView.addObject("category", category);
        return modelAndView;
    }
}

