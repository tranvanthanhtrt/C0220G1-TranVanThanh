package com.thanhtrt.blog.controller;

import com.thanhtrt.blog.model.Blog;
import com.thanhtrt.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

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
    public ModelAndView listBlog() {
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);

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
        Blog blog = blogService.findById(id);
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
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog != null) {
            modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog);

        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }
}
